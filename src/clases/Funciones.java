/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author 
 */
public class Funciones {
       
    public ReturnProperties p = new ReturnProperties();
    
    public static int idClient = 0;
    
    public static String Placas = "";
    public String Datos_Nombre = "nombre";
    public String Datos_Direccion = "direccion";
    public String Datos_Rfc = "rfc";
    public String Datos_Telefono = "telefono";
    
    public final ArrayList ListClients = new ArrayList();
    Conexion coneccion;
    
    //IdGlobal username
    private static int idUsername = 0;
    
    
    //Variables funcion back
    public static int idBack = 0, BackTmp = 0;
    public final ArrayList ListBack = new ArrayList();
    public static int BackVehiculos_consultar = 1;
    public static int BackVehiculos_agregar = 2;
    public static int BackClientes_agregar = 3;
    public static int BackClientes_consultar = 4;
    public static int BackProvedores_Agregar = 5;
    public static int BackProvedores_Consultar = 6;
    
    
    
    public void SetModelForm (JFrame f)
    {
            //Insertamos titulo, imagen y centramos frame
            f.setTitle("FLETES LEMARGO");
            f.setLocationRelativeTo(null);
            f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon.png")));
    }

    public void SetUpercase_Jtextfield (JTextField t)
    {
            t.setText(t.getText().toUpperCase());
    }
    
    public void Jtext_SetModel (JTextField t)
    {
            //Centramos jtextfield
            t.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void JtextField_SetEmpty (JTextField t)
    {
            //Limpiamos Jtextfield
            t.setText("");
    }
    
    public void Alert (String msg)
    {
        //Se muestra notificaciones
        System.out.println(msg.toUpperCase());
    }    

    public boolean Login (JTextField TxtUsername, JTextField TxtPassword)
    {
        boolean respuesta = false;
        try {
            coneccion = new Conexion();
            try (ResultSet rs = coneccion.Consulta("SELECT id FROM users where username = '"+ TxtUsername.getText() +"' and password = '"+ TxtPassword.getText() +"' ")) {
                if (rs.next())
                {
                    idUsername = rs.getInt(1);
                    respuesta = true;
                }else
                {
                    TxtUsername.setText("");
                    TxtPassword.setText("");
                }
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
        return respuesta;
    }
    
    public boolean AddClient (JTextField nombre, JTextField direccion, JTextField telefono, JTextField rfc, JTextField mail) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (nombre.getText().replace(" ", "").length() > 0)
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("insert into clients (nombre, direccion, telefono, rfc, mail) values ('"+nombre.getText().toUpperCase()+"', '"+direccion.getText().toUpperCase()+"', '"+telefono.getText().toUpperCase()+"', '"+rfc.getText().toUpperCase()+"', '"+mail.getText().toUpperCase()+"')");
        }else
        {
            return false;
        }
        
    }
    
    private void StyleJtable(JTable t) {
        try {
            //Tipo de letra
            if (p.ReturnMinuscula(p.Table_HeaderBold).equals("yes"))
            {
                t.getTableHeader().setFont(new Font(p.ReturnPropiedad(p.Table_FondHeader), 1, p.ReturnINT(p.Table_FondZiseHeader))); 
            }else
            {
                t.getTableHeader().setFont(new Font(p.ReturnPropiedad(p.Table_FondHeader), 0, p.ReturnINT(p.Table_FondZiseHeader))); 
            }
            
            if (p.ReturnMinuscula(p.Table_BodyBold).equals("yes"))
            {
                t.setFont(new java.awt.Font(p.ReturnPropiedad(p.Table_FondBody), 1, p.ReturnINT(p.Table_FondZiseBody)));
            }else
            {
                t.setFont(new java.awt.Font(p.ReturnPropiedad(p.Table_FondBody), 0, p.ReturnINT(p.Table_FondZiseBody)));
            }
            
            t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            t.getTableHeader().setReorderingAllowed(false);
            t.getTableHeader().setResizingAllowed(false);
            
            //Centrar header
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) t.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(0);
            
            //Centrar celdas
            DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
            modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
            
            for (int i = 0; i < t.getColumnCount(); i++)
            {
                t.getColumnModel().getColumn(i).setCellRenderer(modelocentrar); 
            }
            
            //No permitir editar celdas
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
        } catch (IOException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadClients(JTable t)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("RFC");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM clients order by id desc");
            Object [] file = new Object[5];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(4);
                file[4] = rs.getString(5);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadClientsSearch(JTable t, JTextField txt)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("RFC");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM clients where nombre like '%"+txt.getText()+"%' or direccion like '%"+txt.getText()+"%' or rfc like '%"+txt.getText()+"%' or mail like '%"+txt.getText()+"%'order by id desc");
            Object [] file = new Object[5];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(4);
                file[4] = rs.getString(5);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public String Detalles_TableClient(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        String r = "";
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT * FROM clients where id = "+Integer.parseInt((String) t.getValueAt(t.getSelectedRow(), 0))+" ");

        if (rs.next())
        {
            r = "NOMBRE:" + "\n" + rs.getString(2) + "\n" + "\n";
            r += "DIRECCION:" + "\n" + rs.getString(3) + "\n" + "\n";
            r += "TELEFONO:" + "\n" + rs.getString(4) + "\n" + "\n";
            r += "RFC:" + "\n" + rs.getString(5) + "\n" + "\n";
            r += "MAIL:" + "\n" + rs.getString(6) + "\n" + "\n";
        }
        return r;
    }
    
    public void SetImagenJLabel (String ruta, JLabel label)
    {
        File f = new File(ruta);
        
        if (f.exists())
        {
            ImageIcon RutaImage = new ImageIcon(ruta);
            ImageIcon icono = new ImageIcon(RutaImage.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
            label.setText("");
            label.setIcon(icono);
        }else
        {
            //ImageIcon RutaImage = new ImageIcon(RutaPathClientes()+"/default.png");
            //ImageIcon icono = new ImageIcon(RutaImage.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
            label.setText("=0");
            //label.setIcon(icono);
        }
    }
    
    public boolean Clients_EditLoad (JTable t,JTextField nombre, JTextField direccion, JTextField telefono, JTextField rfc, JTextField mail ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        boolean r = false;
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT * FROM clients where id = "+Integer.parseInt((String) t.getValueAt(t.getSelectedRow(), 0))+" ");

        if (rs.next())
        {
            r = true;
            idClient = rs.getInt(1);
            nombre.setText(rs.getString(2));
            direccion.setText(rs.getString(3));
            telefono.setText(rs.getString(4));
            rfc.setText(rs.getString(5));
            mail.setText(rs.getString(6));
        }
        return r;
    }
    
    public boolean Client_Update (JTextField nombre, JTextField direccion, JTextField telefono, JTextField rfc, JTextField mail ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        coneccion = new Conexion();
        return coneccion.ejecutar("update clients set nombre = '"+nombre.getText().toUpperCase()+"', direccion = '"+direccion.getText().toUpperCase()+"', telefono = '"+telefono.getText().toUpperCase()+"', rfc = '"+rfc.getText().toUpperCase()+"', mail = '"+mail.getText().toUpperCase()+"' where id = "+idClient+" ");
    }
    
    public void Combo_LoadCients (JComboBox combo) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        combo.removeAllItems();
        ListClients.clear();
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT id, nombre FROM clients order by nombre asc");
        
        combo.addItem("CLIENTES");
        ListClients.add("0");
        
        while (rs.next())
        {
            ListClients.add(rs.getString(1));
            combo.addItem(rs.getString(2));
        }
        
    }
    
    public boolean Vehiculo_Agregar (JTextField placas, JTextField color, JTextField departamento, JTextField mtp, JTextField kilometros, JComboBox c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (placas.getText().replace(" ", "").length() > 0 && c.getSelectedIndex() > 0)
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("insert into vehiculos (placas, color, departamento, mtp, kilometros, id_client) values ('"+placas.getText().toUpperCase()+"', '"+placas.getText().toUpperCase()+"', '"+departamento.getText().toUpperCase()+"', '"+mtp.getText().toUpperCase()+"', '"+kilometros.getText().toUpperCase()+"', '"+ListClients.get(c.getSelectedIndex())+"')");
        }else
        {
            return false;
        }
        
    }
    
    public void Table_LoadVehiculos(JTable t)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("PROPIETARIO");
            modelo.addColumn("M-T-P");
            modelo.addColumn("COLOR");
            modelo.addColumn("PLACAS");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT c.nombre, v.mtp, v.color, v.placas from vehiculos v, clients c where v.id_client = c.id order by c.nombre asc");
            Object [] file = new Object[4];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(4);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadVehiculos_Search(JTable t, JTextField s) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        t.setModel(modelo);

        modelo.addColumn("PROPIETARIO");
        modelo.addColumn("M-T-P");
        modelo.addColumn("COLOR");
        modelo.addColumn("PLACAS");

        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT c.nombre, v.mtp, v.color, v.placas from vehiculos v, clients c where v.id_client = c.id and v.placas like '%"+s.getText()+"%' or v.id_client = c.id and v.mtp like '%"+s.getText()+"%' or v.id_client = c.id and v.color like '%"+s.getText()+"%' or v.id_client = c.id and c.nombre like '%"+s.getText()+"%' order by c.nombre asc");
        Object [] file = new Object[4];

        while (rs.next())
        {
            file[0] = rs.getString(1);
            file[1] = rs.getString(2);
            file[2] = rs.getString(3);
            file[3] = rs.getString(4);
            modelo.addRow(file);
        }
        StyleJtable(t);
        JtextField_SetEmpty(s);
    }
    
    public String Detalles_TableVehiculos(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        String r = "";
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT c.nombre, v.mtp, v.color, v.placas from vehiculos v, clients c where v.id_client = c.id and v.placas = '"+(String) t.getValueAt(t.getSelectedRow(), 3)+"' ");

        if (rs.next())
        {
            r = "PROPIETARIO:" + "\n" + rs.getString(1) + "\n" + "\n";
            r += "MARCA, TIPO & MODELO:" + "\n" + rs.getString(2) + "\n" + "\n";
            r += "COLOR:" + "\n" + rs.getString(3) + "\n" + "\n";
            r += "PLACAS:" + "\n" + rs.getString(4) + "\n" + "\n";
        }
        return r;
    }
    
    public boolean Vehiculos_LoadValuesEdit(JTable t, JTextField placas, JTextField color, JTextField departamento, JTextField mtp, JTextField kilometros, JComboBox c) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        boolean r = false;
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT * from vehiculos where placas = '"+(String)t.getValueAt(t.getSelectedRow(), 3)+"' ");

        if (rs.next())
        {
            r= true;
            Placas = rs.getString(1);
            placas.setText(Placas); 
            color.setText(rs.getString(2)); 
            departamento.setText(rs.getString(3)); 
            mtp.setText(rs.getString(4)); 
            kilometros.setText(rs.getString(5));
            Combo_LoadCients(c);
            for (Object item : ListClients) 
            {
                if (rs.getInt(6) == Integer.parseInt((String) item))
                {
                    c.setSelectedIndex(ListClients.indexOf(item));
                    break;
                }
            }
        }
        return r;
    }
    
    public boolean Vehiculo_Update (JTextField placas, JTextField color, JTextField departamento, JTextField mtp, JTextField kilometros, JComboBox c) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (!"".equals(Placas.replace(" ", "")) && c.getSelectedIndex() > 0)
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("update vehiculos set placas = '"+placas.getText().toUpperCase()+"', color = '"+color.getText().toUpperCase()+"', departamento = '"+departamento.getText().toUpperCase()+"', mtp = '"+mtp.getText().toUpperCase()+"', kilometros = '"+kilometros.getText().toUpperCase()+"', id_client = "+Integer.parseInt((String) ListClients.get(c.getSelectedIndex()))+" where placas = '"+Placas+"' ");
        }else
        {
            return false;
        }
    }
    
    public String GenerateReport (JTable t, String title, int open)
    {
        String rs = null;
        Object[] options = { "PDF", "EXCEL", "NINGUNO" };
        
        int r = JOptionPane.showOptionDialog(null, 
        "Seleccione el tipo de formato a generar.", 
        "Generar reporte?", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        options, 
        options[0]);
        
        if (r == 0)
        {
            rs = GenerateReporte_pdf(t, title, open);
        }
        else if (r == 1)
        {
            rs = GenerateReporte_xls(t, open);
        }
        return rs;
    }
    
    private String GenerateReporte_pdf (JTable t, String title, int open)
    {
        Document documento = new Document(PageSize.LETTER.rotate(),10,10,10,10);  
        FileOutputStream ficheroPdf;
        File ruta = null;
        com.itextpdf.text.Image imagen = null;
        try {
            imagen = com.itextpdf.text.Image.getInstance(p.ReturnPropiedad(p.Ruta_logo));
            
            char rt = p.ReturnPropiedad(p.Ruta_SaveReports).charAt(p.ReturnPropiedad(p.Ruta_SaveReports).length() -1 );
            
            if ("/".equalsIgnoreCase(String.valueOf(rt)))
            {
                ruta = new File (p.ReturnPropiedad(p.Ruta_SaveReports)+ReturnNombreUsuario().replace(" ","_")+"_"+GetFechaAndHourActual().replace(" ", "_").replace(":", "_").replace("-", "_")+".pdf");
            }else
            {
                ruta = new File (p.ReturnPropiedad(p.Ruta_SaveReports)+"/"+ReturnNombreUsuario().replace(" ","_")+"_"+GetFechaAndHourActual().replace(" ", "_").replace(":", "_").replace("-", "_")+".pdf");
            }
            
            ficheroPdf = new FileOutputStream(ruta);
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
        } catch (DocumentException | IOException ex) {
            Alert("Verifique las rutas de guardado de reportes y logo.");
        }
        
        
        try{
            documento.open();
            
            title += "\nGENERÓ: "+ReturnNombreUsuario();
            
            Paragraph Title = new Paragraph(title.toUpperCase());
            Title.setAlignment(1);
            documento.add(Title);
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.scaleToFit(200, 100);
            
            String membrete = ReturnDatosFisicos(this.Datos_Nombre) + "\n";
            membrete += "DIRECCION: " + ReturnDatosFisicos(this.Datos_Direccion) + "\n";
            membrete += "RFC: " + ReturnDatosFisicos(this.Datos_Rfc)+"\n";
            membrete += "TELEFONO: " + ReturnDatosFisicos(this.Datos_Telefono) + "\n";
            membrete += "GENERO DOCUMENTO: " + ReturnNombreUsuario()+ "\n";
            membrete += "FECHA Y HORA DE GENERACION: " + GetFechaAndHourActual()+ "\n";
            
            /////////
            PdfPTable HeaderDatos = new PdfPTable(2);
            HeaderDatos.setWidthPercentage(100);
            
            documento.add(new Paragraph("\n"));
            
            PdfPCell cell = new PdfPCell(new Phrase(membrete));
            cell.setBorder(0);
            HeaderDatos.addCell(cell);
            cell = new PdfPCell(imagen);
            cell.setBorder(0);
            cell.setHorizontalAlignment(1);
            HeaderDatos.addCell(cell);
        
            documento.add(HeaderDatos);
            documento.add(new Paragraph("\n"));
            /////////
            
            PdfPTable tabla = new PdfPTable(t.getColumnCount());
            
            tabla.setWidthPercentage(100);
            
            for (int i = 0; i < t.getColumnCount(); i++)
            {
                Paragraph header = new Paragraph(t.getColumnName(i));
                header.setAlignment(1);
                tabla.addCell(header);
            }
            
            for (int i = 0; i < t.getRowCount(); i++)
            {
                for (int a = 0; a < t.getColumnCount(); a++)
                {
                    
                    Paragraph campo = new Paragraph(String.valueOf(t.getValueAt(i, a)));
                    campo.setAlignment(1);
                    tabla.addCell(campo);
                }
            }
            
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            
            Paragraph footer = new Paragraph("SOFTWARE Y MAS!"+"\n"+"WWW.CYBERCHOAPAS.COM");
            footer.setAlignment(1);
            documento.add(footer);
            
            documento.close();
            if (open > 0)
            {
                Desktop.getDesktop().open(ruta);
            }
        }catch(IOException | DocumentException ex){
            Alert(ex.getMessage());
        }
        return ruta.getAbsolutePath();
    }
    
    private String GenerateReporte_xls (JTable t, int open)
    {
        String rutaArchivo = "";
        try {
            
            char rt = p.ReturnPropiedad(p.Ruta_SaveReports).charAt(p.ReturnPropiedad(p.Ruta_SaveReports).length() -1 );
            
            if ("/".equalsIgnoreCase(String.valueOf(rt)))
            {
                rutaArchivo = p.ReturnPropiedad(p.Ruta_SaveReports)+ReturnNombreUsuario().replace(" ","_") + rutaArchivo+"_"+GetFechaAndHourActual().replace(":","_").replace(" ","_").replace("-","_")+".xls";
            }else
            {
                rutaArchivo = p.ReturnPropiedad(p.Ruta_SaveReports)+"/"+ReturnNombreUsuario().replace(" ","_") + rutaArchivo+"_"+GetFechaAndHourActual().replace(":","_").replace(" ","_").replace("-","_")+".xls";
            }
            File archivoXLS = new File(rutaArchivo);
            
            if(archivoXLS.exists()) archivoXLS.delete();
                archivoXLS.createNewFile();
            
            Workbook libro = new HSSFWorkbook();
            FileOutputStream archivo = new FileOutputStream(archivoXLS);

            Sheet hoja = libro.createSheet(ReturnDatosFisicos(this.Datos_Nombre));

            for(int f=0;f <t.getRowCount() + 1; f++)
            {
                Row fila = hoja.createRow(f);
                for(int c=0;c<t.getColumnCount();c++)
                {
                
                    Cell celda = fila.createCell(c);
                    
                    if(f==0){
                        celda.setCellValue(String.valueOf(t.getColumnName(c)));
                    }else{
                        celda.setCellValue(String.valueOf(t.getValueAt(f-1, c)));
                    }
                    hoja.autoSizeColumn(c);
                }
            }

            libro.write(archivo);
            archivo.close();
            if (open > 0)
            {
                Desktop.getDesktop().open(archivoXLS);
            }
        } catch (IOException ex) {
            Alert(ex.getMessage());
        }
        return rutaArchivo;
    }
    
    public String ReturnNombreUsuario() {
        
        String Cadena = null;
        try {
            Conexion c = new Conexion();
            ResultSet rs =  c.Consulta("SELECT nombre FROM users where id = "+idUsername+" ");
             
            if (rs.next())
            {
                Cadena = rs.getString(1);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
        {
            Alert(ex.getMessage());
        }
        return Cadena.toUpperCase();
    }
    
    public String GetFechaAndHourActual ()
    {
        java.util.Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        return formato.format(fecha);
    }
    
    public String ReturnDatosFisicos(String campo) 
    {
        String Cadena = null;
        try {
            Conexion c = new Conexion();
            ResultSet rs =  c.Consulta("SELECT "+campo+" FROM datos where id = 1 ");
             
            if (rs.next())
            {
                Cadena = rs.getString(1);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
        {
            Alert(ex.getMessage());
        }
        return Cadena.toUpperCase();
    }
}
