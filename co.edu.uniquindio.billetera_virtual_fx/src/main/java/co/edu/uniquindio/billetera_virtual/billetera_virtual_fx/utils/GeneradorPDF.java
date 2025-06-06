package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.TipoTransaccion;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

public class GeneradorPDF {

    private static final float[] BORDE_COMPLETO = {612f};
    private static final float[] COLUMNAS_TITULO = {320f, 120f, 100f};
    private static final float[] DOS_COLUMNAS = {300f, 300f};
    private static final float[] COLUMNAS_INGRESOS = {80f, 200f, 125f, 125f};
    private static final float[] COLUMNAS_GASTOS = {80f, 150f, 110f, 110f, 80f};
    private static final float[] COLUMNAS_SALDOS = {100f, 100f, 130f, 100f, 100f};
    private static final Border BORDE_PUNTEADO = new DashedBorder(ColorConstants.GRAY, 0.5f);
    private static final Paragraph ESPACIO = new Paragraph("\n");

    public static void exportarTransacciones(UsuarioDto usuario, String tipoReporte,
                                             LinkedList<TransaccionDto> transacciones, LinkedList<CuentaDto> listaCuentas,
                                             LocalDate fechaInicio, LocalDate fechaFin) {
        String nombreArchivo = "Informe_Usuario.pdf";
        String rutaUsuario = System.getProperty("user.home");
        String rutaSalida = rutaUsuario + "/Downloads/";
        File archivo = new File(rutaSalida);

        int contador = 1;
        while (archivo.exists()) {
            nombreArchivo = "Informe_Usuario_" + contador + ".pdf";
            rutaSalida = rutaUsuario + "/Downloads/" + nombreArchivo;
            archivo = new File(rutaSalida);
            contador++;
        }

        try {
            PdfWriter writer = new PdfWriter(rutaSalida);
            PdfDocument pdf = new PdfDocument(writer);
            pdf.setDefaultPageSize(PageSize.LETTER);
            Document documentos = new Document(pdf);
            PdfFont letra = PdfFontFactory.createFont("Helvetica");
            PdfFont letraBold = PdfFontFactory.createFont("Helvetica-Bold");


            Table tablaTitulo = new Table(COLUMNAS_TITULO);
            tablaTitulo.setMarginTop(0f);
            Cell cellTitulo = new Cell().add(new Paragraph("Informe de " + tipoReporte))
                    .setBorder(Border.NO_BORDER)
                    .setFont(letraBold)
                    .setFontSize(14)
                    .setVerticalAlignment(VerticalAlignment.TOP);
            tablaTitulo.addCell(cellTitulo);
            Table tablaFechas = new Table(UnitValue.createPercentArray(new float[]{40, 1, 40}))
                    .useAllAvailableWidth();
            if (!tipoReporte.equals("Saldos")) {
                Cell cellTituloFechaInicio = new Cell().add(new Paragraph("Fecha Inicial Informe:"))
                        .setBorder(Border.NO_BORDER)
                        .setFont(letraBold)
                        .setTextAlignment(TextAlignment.CENTER);
                Cell cellFechaInicio = new Cell().add(new Paragraph(String.valueOf(fechaInicio)))
                        .setBorder(Border.NO_BORDER)
                        .setFont(letra)
                        .setTextAlignment(TextAlignment.CENTER);

                Cell cellVacia = new Cell().add(new Paragraph("")) // Espaciador central
                        .setBorder(Border.NO_BORDER);


                Cell cellTituloFechaFin = new Cell().add(new Paragraph("Fecha Final Informe:"))
                        .setBorder(Border.NO_BORDER)
                        .setFont(letraBold)
                        .setTextAlignment(TextAlignment.CENTER);
                Cell cellFechaFin = new Cell().add(new Paragraph(String.valueOf(fechaFin)))
                        .setBorder(Border.NO_BORDER)
                        .setFont(letra)
                        .setTextAlignment(TextAlignment.CENTER);
                tablaFechas.addCell(cellTituloFechaInicio);
                tablaFechas.addCell(cellVacia);
                tablaFechas.addCell(cellTituloFechaFin);
                tablaFechas.addCell(cellFechaInicio);
                tablaFechas.addCell(cellVacia);
                tablaFechas.addCell(cellFechaFin);
            }
            tablaTitulo.setMarginLeft(0f);
            documentos.add(tablaTitulo);
            documentos.add(tablaFechas);

            documentos.add(ESPACIO);
            Border border = new SolidBorder(ColorConstants.GRAY, 1.5f);
            Table tableBorde = new Table(BORDE_COMPLETO);
            tableBorde.setBorder(border);
            documentos.add(tableBorde);

            documentos.add(ESPACIO);
            documentos.add(obtenerTextoColumna("INFORMACION USUARIO", letraBold).setTextAlignment(TextAlignment.CENTER));
            documentos.add(ESPACIO);

            Table tablaUsuario = new Table(new float[]{3, 7}); // relación ajustada para juntar los datos
            tablaUsuario.setWidth(UnitValue.createPercentValue(60)); // opcional: controla el ancho total
            tablaUsuario.setTextAlignment(TextAlignment.LEFT);

            tablaUsuario.addCell(obtenerTextoColumna("Nombre Completo:", letraBold).setTextAlignment(TextAlignment.LEFT));
            tablaUsuario.addCell(obtenerTextoColumna(usuario.nombreCompleto(), letra).setTextAlignment(TextAlignment.LEFT));

            tablaUsuario.addCell(obtenerTextoColumna("Cédula:", letraBold).setTextAlignment(TextAlignment.LEFT));
            tablaUsuario.addCell(obtenerTextoColumna(usuario.idUsuario(), letra).setTextAlignment(TextAlignment.LEFT));

            tablaUsuario.addCell(obtenerTextoColumna("Correo Electrónico:", letraBold).setTextAlignment(TextAlignment.LEFT));
            tablaUsuario.addCell(obtenerTextoColumna(usuario.correoElectronico(), letra).setTextAlignment(TextAlignment.LEFT));

            tablaUsuario.addCell(obtenerTextoColumna("Número de Teléfono:", letraBold).setTextAlignment(TextAlignment.LEFT));
            tablaUsuario.addCell(obtenerTextoColumna(usuario.numeroTelefono(), letra).setTextAlignment(TextAlignment.LEFT));

            tablaUsuario.addCell(obtenerTextoColumna("Dirección:", letraBold).setTextAlignment(TextAlignment.LEFT));
            tablaUsuario.addCell(obtenerTextoColumna(usuario.direccion(), letra).setTextAlignment(TextAlignment.LEFT));

            tablaUsuario.setMarginBottom(15f);
            documentos.add(tablaUsuario);

            Table tablaDivisoraTransacciones = new Table(BORDE_COMPLETO).setBorder(BORDE_PUNTEADO);
            documentos.add(tablaDivisoraTransacciones
                    .setMarginTop(15f)
                    .setMarginBottom(10f));



            switch (tipoReporte) {
                case "Ingresos":
                    documentos.add(obtenerTextoColumna("Depositos", letraBold)
                            .setTextAlignment(TextAlignment.LEFT));
                    generarListaDepositoRetiro(documentos, transacciones, letra, tablaDivisoraTransacciones);
                    break;
                case "Gastos":
                    generarListaGastos(documentos, transacciones, letra, letraBold, tablaDivisoraTransacciones);
                    break;
                case "Saldos":
                    generarListaSaldos(documentos, listaCuentas, letra, letraBold, tablaDivisoraTransacciones);
                    break;
            }

            PdfCanvas canvas = new PdfCanvas(pdf.getLastPage());
            canvas.beginText();
            canvas.setFontAndSize(PdfFontFactory.createFont(), 12);

            canvas.moveText(40, 35);
            canvas.showText("Documento generado por el sistema de informes de la Billetera UQ");


            canvas.moveText(0, -15); // Y se reduce para ir a la línea siguiente
            canvas.showText("por Jorge Ocampo y Esteban Valencia");

            canvas.endText();
            canvas.release();

            String logoPath = "C:/Users/ASUS/Documents/GitHub/prog2_proyecto_final_fx/co.edu.uniquindio.billetera_virtual_fx/src/main/java/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/utils/wallet_logo.jpg";
            try {
                ImageData imageData = ImageDataFactory.create(logoPath);
                Image logo = new Image(imageData);
                logo.setAutoScale(true);
                logo.setHorizontalAlignment(HorizontalAlignment.RIGHT);
                logo.setMarginTop(30f);
                documentos.add(logo);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            documentos.close();

            if (archivo.exists()) {
                Desktop.getDesktop().open(archivo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void generarListaSaldos(Document documento, LinkedList<CuentaDto> cuentas, PdfFont letra, PdfFont letraBold, Table tablaDivisoraTransacciones) {
        Table tablaCuentas = new Table(COLUMNAS_SALDOS);
        configurarTablaPrincipal(tablaCuentas);

        tablaCuentas.addCell(new Cell().add(obtenerTextoColumna("Número Cuenta", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaCuentas.addCell(new Cell().add(obtenerTextoColumna("Nombre Banco", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaCuentas.addCell(new Cell().add(obtenerTextoColumna("Nombre Presupuesto", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaCuentas.addCell(new Cell().add(obtenerTextoColumna("Tipo Cuenta", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaCuentas.addCell(new Cell().add(obtenerTextoColumna("Saldo", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        documento.add((tablaCuentas));

        Table listaCuentas = new Table(COLUMNAS_SALDOS);
        listaCuentas.setWidth(100);
        listaCuentas.setFixedLayout();
        double totalSaldo = 0;
        for (CuentaDto cuenta : cuentas) {
            listaCuentas.addCell(obtenerTextoColumna(cuenta.numCuenta(), letra));
            listaCuentas.addCell(obtenerTextoColumna(cuenta.nombreBanco(), letra));
            listaCuentas.addCell(obtenerTextoColumna(cuenta.presupuestoAsociado(), letra));
            listaCuentas.addCell(obtenerTextoColumna(cuenta.tipoCuenta().toString(), letra));
            listaCuentas.addCell(obtenerTextoColumna(String.format("$%,.0f", cuenta.saldo()), letra));
            totalSaldo += cuenta.saldo();
        }
        listaCuentas.setBorder(Border.NO_BORDER);
        documento.add(listaCuentas);

        float[] columnasTotal = {330f, 200f};
        Table tablaTotal = obtenerDivisorMontoTotal(columnasTotal, tablaDivisoraTransacciones);
        documento.add(tablaTotal);

        float[] columnasMontoTotal = {330f, 100f, 100f};
        Table tablaMontoTotal = obtenerTablaMontoTotal(columnasMontoTotal, letra,
                totalSaldo);
        documento.add(tablaMontoTotal);
    }

    private static double generarListaDepositoRetiro(Document documento, LinkedList<TransaccionDto> transacciones,
                                                     PdfFont letra, Table tablaDivisoraTransacciones) {
        Table tablaTransacciones = new Table(COLUMNAS_INGRESOS);
        tablaTransacciones.setWidth(100);
        tablaTransacciones.setFixedLayout();
        tablaTransacciones.setBackgroundColor(ColorConstants.BLUE, 0.7f);

        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Fecha", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Descripción", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Cuenta", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Monto", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        documento.add(new Cell().add(tablaTransacciones).setBorder(Border.NO_BORDER));

        Table listaTransacciones = new Table(COLUMNAS_INGRESOS);
        double total = 0;
        for (TransaccionDto t : transacciones) {
            if (!t.tipoTransaccion().equals(TipoTransaccion.TRANSFERENCIA)) {
                listaTransacciones.addCell(obtenerTextoColumna(t.fecha().toString(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(t.descripcion(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(t.numCuentaOrigen(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(String.format("$%,.0f", t.monto()), letra));
                total += t.monto();
            }
        }
        documento.add(new Cell().add(listaTransacciones).setBorder(Border.NO_BORDER));

        float[] columnasTotal = {280f, 250f};
        Table tablaTotal = obtenerDivisorMontoTotal(columnasTotal, tablaDivisoraTransacciones);
        documento.add(tablaTotal);

        float[] columnasMontoTotal = {280f, 125f, 125f};
        Table tablaMontoTotal = obtenerTablaMontoTotal(columnasMontoTotal, letra, total);
        documento.add(tablaMontoTotal);
        return total;
    }

    private static void generarListaGastos(Document documento, LinkedList<TransaccionDto> transacciones,
                                           PdfFont letra, PdfFont letraBold, Table tablaDivisoraTransacciones) {
        documento.add(obtenerTextoColumna("Retiros", letraBold)
                .setTextAlignment(TextAlignment.LEFT));
        double saldoGastos = generarListaDepositoRetiro(documento, transacciones, letra, tablaDivisoraTransacciones);

        documento.add(obtenerTextoColumna("Transferencias", letraBold)
                .setTextAlignment(TextAlignment.LEFT));
        saldoGastos += generarListaTransferencias(documento, transacciones, letra, tablaDivisoraTransacciones);

        documento.add(ESPACIO);
        documento.add(obtenerTextoColumna("Total Gastos", letra)
                .setTextAlignment(TextAlignment.CENTER));
        documento.add(obtenerTextoColumna(String.format("$%,.0f", saldoGastos), letra)
                .setTextAlignment(TextAlignment.CENTER));

    }

    private static double generarListaTransferencias(Document documento, LinkedList<TransaccionDto> transacciones,
                                                     PdfFont letra, Table tablaDivisoraTransacciones) {
        Table tablaTransacciones = new Table(COLUMNAS_GASTOS);
        configurarTablaPrincipal(tablaTransacciones);

        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Fecha", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Descripción", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Cuenta Origen", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Cuenta Destino", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        tablaTransacciones.addCell(new Cell().add(obtenerTextoColumna("Monto", letra))
                .setFontColor(ColorConstants.WHITE)
                .setBorder(Border.NO_BORDER));
        documento.add(new Cell().add(tablaTransacciones).setBorder(Border.NO_BORDER));

        Table listaTransacciones = new Table(COLUMNAS_GASTOS);
        listaTransacciones.setWidth(100);
        listaTransacciones.setFixedLayout();
        double totalTransferencia = 0;
        for (TransaccionDto t : transacciones) {
            if (t.tipoTransaccion().equals(TipoTransaccion.TRANSFERENCIA)) {
                listaTransacciones.addCell(obtenerTextoColumna(t.fecha().toString(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(t.descripcion(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(t.numCuentaOrigen(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(t.numCuentaDestino(), letra));
                listaTransacciones.addCell(obtenerTextoColumna(String.format("$%,.0f", t.monto()), letra));
                totalTransferencia += t.monto();
            }
        }
        listaTransacciones.setBorder(Border.NO_BORDER);
        documento.add(listaTransacciones);

        float[] columnasTotal = {340f, 190f};
        Table tablaTotal = obtenerDivisorMontoTotal(columnasTotal, tablaDivisoraTransacciones);
        documento.add(tablaTotal);

        float[] columnasMontoTotal = {340f, 110f, 80f};
        Table tablaMontoTotal = obtenerTablaMontoTotal(columnasMontoTotal, letra,
                totalTransferencia);
        documento.add(tablaMontoTotal);
        return totalTransferencia;


    }

    private static void configurarTablaPrincipal(Table tabla) {
        tabla.setWidth(100);
        tabla.setFixedLayout();
        tabla.setBackgroundColor(ColorConstants.BLUE, 0.7f);
    }

    private static Table obtenerDivisorMontoTotal(float[] columnasTotal, Table tablaDivisora) {
        Table tablaTotal = new Table(columnasTotal).setBorder(Border.NO_BORDER);
        tablaTotal.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tablaTotal.addCell(new Cell().add(tablaDivisora).setBorder(Border.NO_BORDER));
        return tablaTotal;
    }

    private static Table obtenerTablaMontoTotal(float[] columnasTotal, PdfFont letra, double total) {
        Table tablaMontoTotal = new Table(columnasTotal);
        tablaMontoTotal.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tablaMontoTotal.addCell(obtenerTextoColumna("Total", letra));
        tablaMontoTotal.addCell(obtenerTextoColumna("$" + String.format("%,.0f", total), letra));
        return tablaMontoTotal;
    }

    private static Cell obtenerTextoColumna(String nombreColumna, PdfFont letra) {
        String textoValidado = (nombreColumna != null) ? nombreColumna : "";

        return new Cell().add(new Paragraph(textoValidado))
                .setBorder(Border.NO_BORDER)
                .setFontSize(11f)
                .setFont(letra)
                .setTextAlignment(TextAlignment.LEFT);
    }


}
