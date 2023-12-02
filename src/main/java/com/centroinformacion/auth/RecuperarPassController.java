package com.centroinformacion.auth;

import com.centroinformacion.entity.Usuario;
import com.centroinformacion.mail.application.dto.EmailDTO;
import com.centroinformacion.mail.domain.service.IEmailService;
import com.centroinformacion.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
public class RecuperarPassController {
    private String code;
    private Usuario usuario;

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private IEmailService emailService;

    @GetMapping("/password-reset")
    public String verRecuperacionContrasena() {
        return "intranetRecuperarPass";
    }

    @PostMapping("/password-reset-send-v")
    public String verMensajeRecuperacionContrasena() {
        return "intranetMensajeAlEnviarCodigo";
    }


    @PostMapping("/password-reset-send")
    public String validarEmail(@RequestParam String email, HttpSession session, HttpServletRequest request, Model model) {
        List<Usuario> userExist = usuarioService.listarPorCorreo(email);
        if (userExist.size() == 0) {
            System.out.println("El usuario no existe");
        } else {
            this.usuario = userExist.get(0);
            this.code = generarCodigo();
            String[] correos = {email};
            emailService.sendEmail(correos, "Recuperación Contraseña - Linertec", "Codigo : " + code);
        }
        return "intranetRecuperarPass";

    }

    @PostMapping("/password-reset-send-code-validation")
    public String validarEmail(@RequestParam String code) {
        if (usuario == null) {
            return "intranetLogin";
        }
        if (code.equalsIgnoreCase(this.code)) {
            System.out.println("Codigo Correcto");
            return "intranetCambiarContrasena";
        }
        return "intranetMensajeAlEnviarCodigo";


    }

    @PostMapping("/password-reset-send-code-validation-changepass")
    public String changePasswordUser(@RequestParam String password) {
        String[] correos = {usuario.getCorreo()};
        usuario.setPassword(password);
        usuarioService.insertaActualizaUsuario(usuario);
        emailService.sendEmail(correos, "Cambio de Contraseña - Linertec", "Tu contraseña a cambiado \n Tu Password es : " + password);
        return "intranetLogin";


    }

    public static String generarCodigo() {
        int longitud = 6; // longitud del código
        StringBuilder codigoGenerado = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            // Generar un número aleatorio entre 0 y 35
            int aleatorio = random.nextInt(36);

            // Convertir el número a un carácter, ya sea número o letra mayúscula
            char caracter;
            if (aleatorio < 10) {
                // Números: 0-9
                caracter = (char) ('0' + aleatorio);
            } else {
                // Letras mayúsculas: A-Z (usando valores ASCII)
                caracter = (char) ('A' + (aleatorio - 10));
            }

            codigoGenerado.append(caracter);
        }

        return codigoGenerado.toString();
    }
}
