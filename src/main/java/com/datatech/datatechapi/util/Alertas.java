package com.datatech.datatechapi.util;

import com.datatech.datatechapi.App;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class Alertas {
    public static void emitirAlerta() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Professor(a) possui restrição de horário!!!" )
                .title("RESTRIÇÂO VERIFICADA!!")
                .showWarning();

    }

    public static void emitirAlertaAlocacao() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Professor(a) já está alocado(a) em outra sala!!!" )
                .title("ALOCAÇÂO VERIFICADA!!!")
                .showWarning();

    }

    public static void emitirAlertaGradeCriada() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Esse curso já possui uma grade cadastrada!!! " )
                .title("Atenção")
                .showWarning();

    }

    public static void emitirAlertaCampoCurso() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("O campo CURSO deve ser preenchido!!!")
                .title("Necessário atençaõ")
                .showWarning();
    }

    public static void emitirAlertaGradeSalva() throws IOException {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("A sua grade foi salva com sucesso!!!")
                .title("Sucesso")
                .showInformation();
    }

    public static void emitirAlertaRestricaoCamposVazios() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Os campos DATA e HORÁRIO deve ser preenchido!!!")
                .title("Necessário atençaõ")
                .showWarning();
    }

    public static void emitirAlertaRestricaoSalva() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Restrição salva com sucesso!!!")
                .title("Restrição")
                .showInformation();
    }

    public static void emitirAlertaRestricaoExcluids() {
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Restrição excluida com sucesso!!!")
                .title("Restrição")
                .showInformation();
    }

    public static void emitirAlertaUsuarioNaoExiste() {
        Notifications.create()
                .title("Login DataTech API")
                .position(Pos.TOP_CENTER)
                .text("Usuário não existe!!!")
                .darkStyle()
                .showError();
    }
    public static void emitirAlertaUsuarioInvalido()
    {
        Notifications.create()
                .title("Login DataTech API")
                .position(Pos.TOP_CENTER)
                .text("Usuário ou senha inválidos!!!")
                .darkStyle()
                .showError();
    }
    public static void emitirAlertaRetricoesJaExiste(){
        Notifications.create()
                .darkStyle()
                .position(Pos.CENTER)
                .text("Restrição já existe no cadastro!!!")
                .title("Restrição")
                .showWarning();
    }
    public static void emitirAlertaSelecao(){
        Notifications.create()
                .title("Atenção")
                .text("Selecione uma restrição para continuar!!!")
                .darkStyle()
                .position(Pos.CENTER)
                .showWarning();
    }
}
