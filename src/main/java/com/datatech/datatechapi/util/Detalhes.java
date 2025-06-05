package com.datatech.datatechapi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Detalhes {

    public static String mostrarDataHora(){

        var formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        var dataHora = (LocalDateTime.now());

       String data = formatador.format(dataHora);

       return "@Copyright DATAGRADE     DATATECHAPI " + "     " + data;
    }
}
