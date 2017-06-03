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
import java.awt.Checkbox;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    
    public static int idClient = 0, idProvedor = 0;
    
    public static String Placas = "";
    public String Datos_Nombre = "nombre";
    public String Datos_Direccion = "direccion";
    public String Datos_Rfc = "rfc";
    public String Datos_Telefono = "telefono";
    
    public final ArrayList ListClients = new ArrayList();
    public final ArrayList ListProvedores = new ArrayList();
    public final ArrayList ListVehiculos = new ArrayList();
    public final ArrayList ListProducts = new ArrayList();
    
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
    public static int BackStock_Agregar = 7;
    public static int BackStock_Consultar = 8;
    
    //Permisos
    public static final String PermisoClients = "clientes";
    public static final String PermisoClients_add = "clientes_agregar";
    public static final String PermisoClients_edit = "clientes_editar";
    public static final String PermisoClients_delete = "clientes_eliminar";
    public static final String PermisoVehiculos = "vehiculos";
    public static final String PermisoVehiculos_add = "vehiculos_agregar";
    public static final String PermisoVehiculos_edit = "vehiculos_editar";
    public static final String PermisoVehiculos_delete = "vehiculos_eliminar";
    public static final String PermisoProvedores = "provedores";
    public static final String PermisoProvedores_add = "provedores_agregar";
    public static final String PermisoProvedores_edit = "provedores_editar";
    public static final String PermisoProvedores_delete = "provedores_eliminar";
    public static final String PermisoStock = "stock";
    public static final String PermisoStocks_add = "stock_agregar";
    public static final String PermisoStock_edit = "stock_editar";
    public static final String PermisoStock_delete = "stock_eliminar";
    public static final String PermisoInventory = "inventario";
    public static final String PermisoUsers = "users";
    public static final String PermisoUsers_add = "user_add";
    public static final String PermisoUsers_edit = "user_update";
    public static final String PermisoUsers_delete = "user_delete";
    public static final String PermisoUpdate_datos = "update_dates";
    
            
    public void SetModelForm (JFrame f)
    {
        f.setTitle(this.ReturnDatosFisicos(this.Datos_Nombre) + ", " + this.ReturnDatosFisicos(this.Datos_Direccion) + " - RFC: "+ this.ReturnDatosFisicos(this.Datos_Rfc));
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
        if (nombre.getText().replace(" ", "").length() > 0 && Get_Permiso(Funciones.PermisoClients))
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
    
    public boolean Delete_TableClient(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (Get_Permiso(Funciones.PermisoClients_delete))
        {
            return coneccion.ejecutar("delete from clients where id = "+Integer.parseInt((String) t.getValueAt(t.getSelectedRow(), 0))+" ");
        }else
        {
            return false;
        }
    }
    
    public boolean Delete_ItemVehiculo(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (Get_Permiso(Funciones.PermisoVehiculos_delete))
        {
            return coneccion.ejecutar("delete from vehiculos where placas = '"+(String) t.getValueAt(t.getSelectedRow(), 3)+"' ");
        }else
        {
            return false;
        }
    }
    
    public boolean Delete_ItemProvedores(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (Get_Permiso(Funciones.PermisoProvedores_delete))
        {
            return coneccion.ejecutar("delete from provedores where id = "+Integer.parseInt((String) t.getValueAt(t.getSelectedRow(), 0))+" ");
        }else
        {
            return false;
        }
    }
    
    public boolean Delete_ItemProducts(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (Get_Permiso(Funciones.PermisoStock_delete))
        {
            return coneccion.ejecutar("delete from products where codebar = '"+(String) t.getValueAt(t.getSelectedRow(), 0)+"' ");
        }else
        {
            return false;
        }
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
        if (Get_Permiso(Funciones.PermisoClients_edit))
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("update clients set nombre = '"+nombre.getText().toUpperCase()+"', direccion = '"+direccion.getText().toUpperCase()+"', telefono = '"+telefono.getText().toUpperCase()+"', rfc = '"+rfc.getText().toUpperCase()+"', mail = '"+mail.getText().toUpperCase()+"' where id = "+idClient+" ");
        }else
        {
            return false;
        }
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
    
    public void Combo_LoadProvedores (JComboBox combo) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        combo.removeAllItems();
        ListProvedores.clear();
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT id, empresa FROM provedores order by empresa asc");
        
        combo.addItem("PROVEDORES");
        ListProvedores.add("0");
        
        while (rs.next())
        {
            ListProvedores.add(rs.getString(1));
            combo.addItem(rs.getString(2));
        }
        
    }
    
    public boolean Vehiculo_Agregar (JTextField placas, JTextField color, JTextField departamento, JTextField mtp, JTextField kilometros, JComboBox c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (placas.getText().replace(" ", "").length() > 0 && c.getSelectedIndex() > 0)
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("insert into vehiculos (placas, color, departamento, mtp, kilometros, id_client) values ('"+placas.getText().toUpperCase()+"', '"+color.getText().toUpperCase()+"', '"+departamento.getText().toUpperCase()+"', '"+mtp.getText().toUpperCase()+"', '"+kilometros.getText().toUpperCase()+"', '"+ListClients.get(c.getSelectedIndex())+"')");
        }else
        {
            return false;
        }
        
    }
    
    public boolean Product_Add (JTextField CodeBar, JTextField nombre, JTextField descripcion, JTextField precio, JTextField existencia, JComboBox c) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (CodeBar.getText().replace(" ", "").length() > 0 && c.getSelectedIndex() > 0 && Get_Permiso(Funciones.PermisoStocks_add))
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("insert into products (codebar, nombre, descripcion, precio, existencia, vendidos, id_provedor) values ('"+CodeBar.getText().toUpperCase()+"', '"+nombre.getText().toUpperCase()+"', '"+descripcion.getText().toUpperCase()+"', '"+precio.getText().toUpperCase()+"', '"+existencia.getText().toUpperCase()+"', 0,'"+ListProvedores.get(c.getSelectedIndex())+"')");
        }else
        {
            return false;
        }
    }
    
    public boolean Add_User (JTextField TxtUsername, JTextField Contraseña, JTextField Nombre, JTextField Direccion, JTextField telefonos) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (!"".equals(TxtUsername.getText().replace(" ","")) && !"".equals(Contraseña.getText().replace(" ","")))
        {
            coneccion = new Conexion();
            if (Get_Permiso(Funciones.PermisoUsers_add))
            {
                return coneccion.ejecutar("insert into users (username, password, nombre, direccion, telefono) values ('"+TxtUsername.getText()+"', '"+Contraseña.getText()+"', '"+Nombre.getText()+"', '"+Direccion.getText()+"', '"+telefonos.getText()+"')");
            }else
            {
                return  false;
            }
        }else
        {
            Alert("Ingrese almenos usuario y una contraseña");
            return  false;
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
    
    public void Table_LoadProducts(JTable t)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("CODIGO DE BARRA");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("PRECIO");
            modelo.addColumn("STOCK");
            modelo.addColumn("PROVEDOR");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT p.codebar, p.nombre, p.precio, p.existencia, p.vendidos, pp.empresa from provedores pp, products p where pp.id = p.id_provedor order by p.nombre asc");
            Object [] file = new Object[5];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(4);
                file[4] = rs.getString(6);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadInventory(JTable t)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("CODIGO DE BARRA");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("PRECIO");
            modelo.addColumn("PROVEDOR");
            modelo.addColumn("STOCK");
            modelo.addColumn("VENDIDOS");
            modelo.addColumn("TOTAL");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT p.codebar, p.nombre, p.precio, pp.empresa, p.existencia, p.vendidos from provedores pp, products p where pp.id = p.id_provedor order by p.nombre asc");
            Object [] file = new Object[7];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(4);
                file[4] = rs.getString(5);
                file[5] = rs.getString(6);
                file[6] = rs.getInt(5) + rs.getInt(6);
                
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
    
    public boolean Product_LoadValuesEdit(JTable t, JTextField codebar, JTextField nombre, JTextField descripcion, JTextField precio, JTextField existencia, JComboBox c) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        boolean r = false;
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT * from products where codebar = '"+(String)t.getValueAt(t.getSelectedRow(), 0)+"' ");

        if (rs.next())
        {
            r= true;
            codebar.setText(rs.getString(1));
            nombre.setText(rs.getString(2));
            descripcion.setText(rs.getString(3));
            precio.setText(rs.getString(4));
            existencia.setText(rs.getString(5));
            Combo_LoadProvedores(c);
            for (Object item : ListProvedores) 
            {
                if (rs.getInt(7) == Integer.parseInt((String) item))
                {
                    c.setSelectedIndex(ListProvedores.indexOf(item));
                    break;
                }
            }
        }
        return r;
    }
    
    public boolean Vehiculo_Update (JTextField placas, JTextField color, JTextField departamento, JTextField mtp, JTextField kilometros, JComboBox c) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (!"".equals(Placas.replace(" ", "")) && c.getSelectedIndex() > 0 && Get_Permiso(Funciones.PermisoVehiculos_edit))
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("update vehiculos set placas = '"+placas.getText().toUpperCase()+"', color = '"+color.getText().toUpperCase()+"', departamento = '"+departamento.getText().toUpperCase()+"', mtp = '"+mtp.getText().toUpperCase()+"', kilometros = '"+kilometros.getText().toUpperCase()+"', id_client = "+Integer.parseInt((String) ListClients.get(c.getSelectedIndex()))+" where placas = '"+Placas+"' ");
        }else
        {
            return false;
        }
    }
    
    public boolean Product_Update (String code, JTextField codebar, JTextField nombre, JTextField descripcion, JTextField precio, JTextField existencia, JComboBox c) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (c.getSelectedIndex() > 0 && Get_Permiso(Funciones.PermisoStock_edit))
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("update products set codebar = '"+codebar.getText().toUpperCase()+"', nombre = '"+nombre.getText().toUpperCase()+"', descripcion = '"+descripcion.getText().toUpperCase()+"', precio = '"+precio.getText().toUpperCase()+"', existencia = '"+existencia.getText().toUpperCase()+"', id_provedor = "+Integer.parseInt((String) ListProvedores.get(c.getSelectedIndex()))+" where codebar = '"+code+"' ");
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
    
    public boolean AddProvedor (JTextField TxtEmpresa, JTextField TxtTelEmpresa, JTextField TxtMail, JTextField TxtResponsable, JTextField TxtDireccion) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if (TxtEmpresa.getText().replace(" ", "").length() > 0)
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("insert into provedores (empresa, direccion, telefono_empresa, responsable, mail) values ('"+TxtEmpresa.getText().toUpperCase()+"', '"+TxtDireccion.getText().toUpperCase()+"', '"+TxtTelEmpresa.getText().toUpperCase()+"', '"+TxtResponsable.getText().toUpperCase()+"', '"+TxtMail.getText().toUpperCase()+"' ) ");
        }else
        {
            return false;
        }
        
    }
    
    public void Table_LoadProvedores(JTable t)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("ID");
            modelo.addColumn("EMPRESA");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("RESPONSABLE");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM provedores order by id desc");
            Object [] file = new Object[4];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(5);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadUsers(JTable t)
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
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM users order by nombre desc");
            Object [] file = new Object[4];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(4);
                file[2] = rs.getString(5);
                file[3] = rs.getString(6);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadProvedoresSearch(JTable t, JTextField txt)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("ID");
            modelo.addColumn("EMPRESA");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("RESPONSABLE");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM provedores where empresa like '%"+txt.getText()+"%' or direccion like '%"+txt.getText()+"%' or responsable like '%"+txt.getText()+"%' order by id desc");
            Object [] file = new Object[4];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(5);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public void Table_LoadProductsSearch(JTable t, JTextField txt)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("CODIGO DE BARRA");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("PRECIO");
            modelo.addColumn("STOCK");
            modelo.addColumn("PROVEDOR");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT p.codebar, p.nombre, p.precio, p.existencia, p.vendidos, pp.empresa from provedores pp, products p where pp.id = p.id_provedor and codebar LIKE '%"+txt.getText()+"%' or pp.id = p.id_provedor and nombre LIKE '%"+txt.getText()+"%' or pp.id = p.id_provedor and descripcion LIKE '%"+txt.getText()+"%' or pp.id = p.id_provedor and pp.empresa LIKE '%"+txt.getText()+"%' order by p.nombre asc");
            Object [] file = new Object[5];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(2);
                file[2] = rs.getString(3);
                file[3] = rs.getString(4);
                file[4] = rs.getString(6);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public String Detalles_TableProvedores(JTable t) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        String r = "";
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT * FROM provedores where id = "+Integer.parseInt((String) t.getValueAt(t.getSelectedRow(), 0))+" ");

        if (rs.next())
        {
            r = "EMPRESA:" + "\n" + rs.getString(2) + "\n" + "\n";
            r += "DIRECCION:" + "\n" + rs.getString(3) + "\n" + "\n";
            r += "TELEFONO EMPRESA:" + "\n" + rs.getString(4) + "\n" + "\n";
            r += "RESPONDABLE:" + "\n" + rs.getString(5) + "\n" + "\n";
            r += "CORREO ELECTRONICO:" + "\n" + rs.getString(6) + "\n" + "\n";
        }
        return r;
    }
    
    public boolean Provedor_EditLoad (JTable t, JTextField TxtEmpresa, JTextField TxtTelEmpresa, JTextField TxtTelResponsable, JTextField TxtResponsable, JTextField TxtDireccion ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        boolean r = false;
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT * FROM provedores where id = "+Integer.parseInt((String) t.getValueAt(t.getSelectedRow(), 0))+" ");

        if (rs.next())
        {
            r = true;
            idProvedor = rs.getInt(1);
            TxtEmpresa.setText(rs.getString(2));
            TxtDireccion.setText(rs.getString(3));
            TxtTelEmpresa.setText(rs.getString(4));
            TxtResponsable.setText(rs.getString(5));
            TxtTelResponsable.setText(rs.getString(6));
            
        }
        return r;
    }
    
    public boolean Provedor_Update (JTextField TxtEmpresa, JTextField TxtTelEmpresa, JTextField TxtTelResponsable, JTextField TxtResponsable, JTextField TxtDireccion ) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (Get_Permiso(Funciones.PermisoProvedores_edit))
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("update provedores set empresa     = '"+TxtEmpresa.getText().toUpperCase()+"', direccion = '"+TxtDireccion.getText().toUpperCase()+"', telefono_empresa = '"+TxtTelEmpresa.getText().toUpperCase()+"', responsable = '"+TxtResponsable.getText().toUpperCase()+"', mail = '"+TxtTelResponsable.getText().toUpperCase()+"' where id = "+idProvedor+" ");
        }else
        {
            return false;
        }
    }
    
    public boolean Get_Permiso(String campo)
    {
        boolean r = false;
        try {
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT "+campo+" FROM permisos WHERE id_user = "+idUsername+" ");
            if (rs.next())
            {
                if (rs.getInt(1) == 1)
                {
                    r = true;
                }
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
        
        if (r == false)
        {
            Alert("PERMISO NO AUTORIZADO"+ "\n" +"O CON POCOS PRIVILEGIOS.");
        }
        return r;
    }
    
    public boolean ExistProduct (String code) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        boolean var = false;
        
        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT '"+code+"' FROM products");
        
        if (rs.next())
        {
            var = true;
        }
        return var;
    }

    public void setvaluesUser(int id, JTextField TxtUsername, JTextField Contraseña, JTextField Nombre, JTextField Direccion, JTextField telefonos) {
        if (ValidarUserPermisos(id) == false)
        {
            User_AddFirstPermisos(id);
        };
        try {
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM users where id = "+id+" ");
            
            if (rs.next())
            {
                TxtUsername.setText(rs.getString(2));
                Contraseña.setText(rs.getString(3));
                Nombre.setText(rs.getString(4));
                Direccion.setText(rs.getString(5));
                telefonos.setText(rs.getString(6));
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public boolean Update_valuesUser(int id, JTextField TxtUsername, JTextField Contraseña, JTextField Nombre, JTextField Direccion, JTextField telefonos) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (Get_Permiso(Funciones.PermisoUsers_edit) && id > 0)
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("update users set username = '"+TxtUsername.getText().toUpperCase()+"', password = '"+Contraseña.getText()+"', nombre = '"+Nombre.getText().toUpperCase()+"', direccion = '"+Direccion.getText().toUpperCase()+"', telefono = '"+telefonos.getText().toUpperCase()+"' where id = "+id+" ");
        }else
        {
            return false;
        }
    }

    public boolean Delete_User(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (Get_Permiso(Funciones.PermisoUsers_delete))
        {
            coneccion = new Conexion();
            return coneccion.ejecutar("delete from users where id = "+id+" ");
        }else
        {
            return false;
        }
    }
    
    public boolean ValidarUserPermisos(int id) {
        boolean r = false;
        
        try {
            coneccion = new Conexion();
            try (ResultSet rs = coneccion.Consulta("SELECT * FROM permisos where id_user = "+id+" ")) {
                if (rs.next())
                {
                    r = true;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException  ex) {
            Alert(ex.getMessage());
        }
         
        return r;
    }
    
    public boolean User_AddFirstPermisos (int id)
    {
        boolean respuesta = false;
        try {
            respuesta = coneccion.ejecutar("INSERT INTO `permisos` (`id_user`, `clientes`, `clientes_agregar`, `clientes_editar`, `clientes_eliminar`, `vehiculos`, `vehiculos_agregar`, `vehiculos_editar`, `vehiculos_eliminar`, `provedores`, `provedores_agregar`, `provedores_editar`, `provedores_eliminar`, `stock`, `stock_agregar`, `stock_editar`, `stock_eliminar`, `inventario`, `users`, `user_add`, `user_update`, `user_delete`, `update_dates`) VALUES ("+id+", '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')");
        } catch (SQLException ex) {
            Alert(ex.getMessage());
        }
        return respuesta;
    }
    public void SetPermisosUsuario(
            int id,
            Checkbox clientes,
            Checkbox clientes_agregar,
            Checkbox clientes_editar,
            Checkbox clientes_eliminar,
            Checkbox vehiculos,
            Checkbox vehiculos_agregar,
            Checkbox vehiculos_editar,
            Checkbox vehiculos_eliminar,
            Checkbox provedores,
            Checkbox provedores_agregar,
            Checkbox provedores_editar,
            Checkbox provedores_eliminar,
            Checkbox stock,
            Checkbox stock_agregar,
            Checkbox stock_editar,
            Checkbox stock_eliminar,
            Checkbox inventario,
            Checkbox users,
            Checkbox user_add,
            Checkbox user_update,
            Checkbox user_delete,
            Checkbox update_dates
    )
    {
        
        if (id != 0)
        {
            try {
                coneccion = new Conexion();
                ResultSet rs = coneccion.Consulta("SELECT * FROM permisos WHERE id_user = "+id+" ");
                if (rs.next())
                {
                    clientes.setState(ReturnState(rs.getInt(2)));
                    clientes_agregar.setState(ReturnState(rs.getInt(3)));
                    clientes_editar.setState(ReturnState(rs.getInt(4)));
                    clientes_eliminar.setState(ReturnState(rs.getInt(5)));
                    vehiculos.setState(ReturnState(rs.getInt(6)));
                    vehiculos_agregar.setState(ReturnState(rs.getInt(7)));
                    vehiculos_editar.setState(ReturnState(rs.getInt(8)));
                    vehiculos_eliminar.setState(ReturnState(rs.getInt(9)));
                    provedores.setState(ReturnState(rs.getInt(10)));
                    provedores_agregar.setState(ReturnState(rs.getInt(11)));
                    provedores_editar.setState(ReturnState(rs.getInt(12)));
                    provedores_eliminar.setState(ReturnState(rs.getInt(13)));
                    stock.setState(ReturnState(rs.getInt(14)));
                    stock_agregar.setState(ReturnState(rs.getInt(15)));
                    stock_editar.setState(ReturnState(rs.getInt(16)));
                    stock_eliminar.setState(ReturnState(rs.getInt(17)));
                    inventario.setState(ReturnState(rs.getInt(18)));
                    users.setState(ReturnState(rs.getInt(19)));
                    user_add.setState(ReturnState(rs.getInt(20)));
                    user_update.setState(ReturnState(rs.getInt(21)));
                    user_delete.setState(ReturnState(rs.getInt(22)));
                    update_dates.setState(ReturnState(rs.getInt(23)));
                }
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                Alert(ex.getMessage());
            }
        }
    }
    
    private boolean ReturnState (int num)
    {
        boolean r = false;
        
        if (num > 0)
        {
            r = true;
        }
        
        return r;
    }
    
    private boolean ReturnStateChecbox (Checkbox c)
    {
        boolean r = false;
        
        if (c.getState() == true)
        {
            r = true;
        }
        
        return r;
    }
    
    public boolean UpdatePermisosYacceso (
            int id,
            Checkbox clientes,
            Checkbox clientes_agregar,
            Checkbox clientes_editar,
            Checkbox clientes_eliminar,
            Checkbox vehiculos,
            Checkbox vehiculos_agregar,
            Checkbox vehiculos_editar,
            Checkbox vehiculos_eliminar,
            Checkbox provedores,
            Checkbox provedores_agregar,
            Checkbox provedores_editar,
            Checkbox provedores_eliminar,
            Checkbox stock,
            Checkbox stock_agregar,
            Checkbox stock_editar,
            Checkbox stock_eliminar,
            Checkbox inventario,
            Checkbox users,
            Checkbox user_add,
            Checkbox user_update,
            Checkbox user_delete,
            Checkbox update_dates
    )
    {
        boolean r = false;
        try {
                r = coneccion.ejecutar("update permisos set clientes = "+ReturnStateChecbox(clientes)+","
                        + " clientes_agregar = "+ReturnStateChecbox(clientes_agregar)+", "
                        + " clientes_editar = "+ReturnStateChecbox(clientes_editar)+", "
                        + " clientes_eliminar = "+ReturnStateChecbox(clientes_eliminar)+", "
                        + " vehiculos = "+ReturnStateChecbox(vehiculos)+", "
                        + " vehiculos_agregar = "+ReturnStateChecbox(vehiculos_agregar)+", "
                        + " vehiculos_editar = "+ReturnStateChecbox(vehiculos_editar)+", "
                        + " vehiculos_eliminar = "+ReturnStateChecbox(vehiculos_eliminar)+", "
                        + " provedores = "+ReturnStateChecbox(provedores)+", "
                        + " provedores_agregar = "+ReturnStateChecbox(provedores_agregar)+", "
                        + " provedores_editar = "+ReturnStateChecbox(provedores_editar)+", "
                        + " provedores_eliminar = "+ReturnStateChecbox(provedores_eliminar)+", "
                        + " stock = "+ReturnStateChecbox(stock)+", "
                        + " stock_agregar = "+ReturnStateChecbox(stock_agregar)+", "
                        + " stock_editar = "+ReturnStateChecbox(stock_editar)+", "
                        + " stock_eliminar = "+ReturnStateChecbox(stock_eliminar)+", "
                        + " inventario = "+ReturnStateChecbox(inventario)+", "
                        + " users = "+ReturnStateChecbox(users)+", "
                        + " user_add = "+ReturnStateChecbox(user_add)+", "
                        + " user_update = "+ReturnStateChecbox(user_update)+", "
                        + " user_delete = "+ReturnStateChecbox(user_delete)+", "
                        + " update_dates = "+ReturnStateChecbox(update_dates)+"  where id_user = "+id+" ");
                        
        } catch (SQLException ex) {
            Alert(ex.getMessage());
        }
        return r;
    }
    
    public void Table_LoadUsersSearch(JTable t, JTextField txt)
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
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM users where username like '%"+txt.getText()+"%' or nombre like '%"+txt.getText()+"%' order by nombre desc");
            Object [] file = new Object[4];

            while (rs.next())
            {
                file[0] = rs.getString(1);
                file[1] = rs.getString(4);
                file[2] = rs.getString(5);
                file[3] = rs.getString(6);
                
                modelo.addRow(file);
            }
            StyleJtable(t);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public String GetRutaImagenJdataChooser ()
    {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        chooser.setFileFilter(filtroImagen);
        chooser.showOpenDialog(null);
        return String.valueOf(chooser.getSelectedFile().getAbsoluteFile()).replace("\\", "/");
    }
    
    public String GetRutaFolderJdataChooser ()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showSaveDialog(null);
        return String.valueOf(fileChooser.getSelectedFile()).replace("\\", "/");
    }
    
    public void AjustesGetProperties 
    (
        JTextField TxtRuta_db,
        JTextField usuario_db,
        JTextField passwors_db,
        JTextField nombre_db,
        JTextField puerto_db,
        JTextField ruta_logo,
        JTextField ruta_savereports,
        JTextField TableFonfHeader,
        JTextField TableFondBody,
        JTextField TableFondZiseBody,
        JTextField TableFondZiseHeader,
        JRadioButton TableFondBodyBold,
        JRadioButton TableFondHeaderBold
    )
    {
        try {
            TxtRuta_db.setText(p.ReturnPropiedad(p.ruta_db));
            usuario_db.setText(p.ReturnPropiedad(p.usuario_db));
            passwors_db.setText(p.ReturnPropiedad(p.passwors_db));
            nombre_db.setText(p.ReturnPropiedad(p.nombre_db));
            puerto_db.setText(p.ReturnPropiedad(p.puerto_db));
            ruta_logo.setText(p.ReturnPropiedad(p.Ruta_logo));
            ruta_savereports.setText(p.ReturnPropiedad(p.Ruta_SaveReports));
            TableFonfHeader.setText(p.ReturnPropiedad(p.Table_FondHeader));
            TableFondBody.setText(p.ReturnPropiedad(p.Table_FondBody));
            TableFondZiseBody.setText(p.ReturnPropiedad(p.Table_FondZiseBody));
            TableFondZiseHeader.setText(p.ReturnPropiedad(p.Table_FondZiseHeader));
            
            if ("yes".equals(p.ReturnMinuscula(p.Table_BodyBold)))
            {
                TableFondBodyBold.setSelected(true);
            }
            
            if ("yes".equals(p.ReturnMinuscula(p.Table_HeaderBold)))
            {
                TableFondHeaderBold.setSelected(true);
            }
        } catch (IOException ex) {
            Alert(ex.getMessage());
        }
            
    }
    
    public void LoadValuesPyme(JTextField TxtNombre, JTextField TxtDireccion, JTextField TxtRfc, JTextField TxtTelefonos)
    {
        
        try {
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT * FROM datos where id = 1 ");
            
            if (rs.next())
            {
                TxtNombre.setText(rs.getString(2).toUpperCase());
                TxtDireccion.setText(rs.getString(3).toUpperCase());
                TxtRfc.setText(rs.getString(4).toUpperCase());
                TxtTelefonos.setText(rs.getString(5).toUpperCase());
                if (!Get_Permiso(Funciones.PermisoUpdate_datos))
                {
                    TxtNombre.enable(false);
                    TxtDireccion.enable(false);
                    TxtRfc.enable(false);
                    TxtTelefonos.enable(false);
                }
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Alert(ex.getMessage());
        }
    }
    
    public boolean AjustesSetProperties
    (
        JTextField TxtRuta_db,
        JTextField usuario_db,
        JTextField passwors_db,
        JTextField nombre_db,
        JTextField puerto_db,
        JTextField ruta_logo,
        JTextField ruta_savereports,
        JTextField TableFonfHeader,
        JTextField TableFondBody,
        JTextField TableFondZiseBody,
        JTextField TableFondZiseHeader,
        JRadioButton TableFondBodyBold,
        JRadioButton TableFondHeaderBold
    )
    {
        boolean r = true;
        File path = new File (".");
        Properties propiedades = new Properties();
        OutputStream salida = null;

        try {
            
            salida = new FileOutputStream(path.getCanonicalPath() + "/config.properties");

            // asignamos los valores a las propiedades
            
            propiedades.setProperty(p.ruta_db,TxtRuta_db.getText() );
            propiedades.setProperty(p.usuario_db,usuario_db.getText() );
            propiedades.setProperty(p.passwors_db,passwors_db.getText() );
            propiedades.setProperty(p.nombre_db,nombre_db.getText() );
            propiedades.setProperty(p.puerto_db,puerto_db.getText() );
            propiedades.setProperty(p.Ruta_logo,ruta_logo.getText() );
            propiedades.setProperty(p.Ruta_SaveReports,ruta_savereports.getText() );
            propiedades.setProperty(p.Table_FondHeader,TableFonfHeader.getText() );
            propiedades.setProperty(p.Table_FondBody,TableFondBody.getText() );
            propiedades.setProperty(p.Table_FondZiseBody,TableFondZiseBody.getText() );
            propiedades.setProperty(p.Table_FondZiseHeader,TableFondZiseHeader.getText() );
            
            
            if (TableFondBodyBold.isSelected())
            {
                propiedades.setProperty(p.Table_BodyBold,"yes");
            }else
            {
                propiedades.setProperty(p.Table_BodyBold,"no");
            }
            
            if (TableFondHeaderBold.isSelected())
            {
                propiedades.setProperty(p.Table_HeaderBold,"yes");
            }else
            {
                propiedades.setProperty(p.Table_HeaderBold,"no");
            }
            
            // guardamos el archivo de propiedades en la carpeta de aplicación
            propiedades.store(salida, null);

        } catch (IOException io) {
            r = false;
            Alert(io.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    r = false;
                    Alert(e.getMessage());
                }
            }

        }
        return r;
    }
    
    public boolean AjustesRestoreProperties ()
    {
        boolean r = true;
        File path = new File (".");
        Properties propiedades = new Properties();
        OutputStream salida = null;

        try {
            
            salida = new FileOutputStream(path.getCanonicalPath() + "/config.properties");

            // asignamos los valores a las propiedades
            
            propiedades.setProperty(p.ruta_db,"//server");
            propiedades.setProperty(p.usuario_db,"username");
            propiedades.setProperty(p.passwors_db,"***");
            propiedades.setProperty(p.nombre_db,"nombre_db");
            propiedades.setProperty(p.puerto_db,"3306");
            propiedades.setProperty(p.Ruta_logo,"/logo.jpg");
            propiedades.setProperty(p.Ruta_SaveReports,"/");
            propiedades.setProperty(p.Table_FondHeader,"arial");
            propiedades.setProperty(p.Table_FondBody,"arial");
            propiedades.setProperty(p.Table_FondZiseBody,"12");
            propiedades.setProperty(p.Table_FondZiseHeader,"16");
            propiedades.setProperty(p.Table_BodyBold,"no");
            propiedades.setProperty(p.Table_HeaderBold,"yes");
            
            // guardamos el archivo de propiedades en la carpeta de aplicación
            propiedades.store(salida, null);

        } catch (IOException io) {
            r = false;
            Alert(io.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    r = false;
                    Alert(e.getMessage());
                }
            }

        }
        return r;
    }
    
    
    public void UpdateDatosEmpresa (JTextField TxtNombre, JTextField TxtDireccion, JTextField TxtRfc, JTextField TxtTelefonos )
    {
        if (Get_Permiso(Funciones.PermisoUpdate_datos))
        {
            try {
                coneccion = new Conexion();
                coneccion.ejecutar("update datos set nombre = '"+TxtNombre.getText().toUpperCase()+"', direccion = '"+TxtDireccion.getText().toUpperCase()+"', rfc = '"+TxtRfc.getText().toUpperCase()+"', telefono = '"+TxtTelefonos.getText().toUpperCase()+"' where id = 1 ");
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                Alert(ex.getMessage());
            }
        }
    }
    
    public void Combo_LoadVehiculos (JComboBox combo, JComboBox combocli) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (combocli.getSelectedIndex() > 0)
        {
            combo.removeAllItems();
            ListVehiculos.clear();

            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT placas, mtp FROM vehiculos where id_client = "+ListClients.get(combocli.getSelectedIndex())+" order by mtp asc");

            combo.addItem("VEHICULOS");
            ListVehiculos.add("0");

            while (rs.next())
            {
                ListVehiculos.add(rs.getString(1));
                combo.addItem(rs.getString(2));
            }
        }
    }
    
    public void Combo_LoadValuesVehiculos (JComboBox c ,JLabel TxtPlacas, JLabel TxtColor, JLabel TxtDepartamento, JLabel TxtKilometraje) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (c.getSelectedIndex() > 0)
        {
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT placas, color, departamento, kilometros FROM vehiculos where placas = '"+ListVehiculos.get(c.getSelectedIndex())+"' ");

            if (rs.next())
            {
                TxtPlacas.setText(rs.getString(1));
                TxtColor.setText(rs.getString(2));
                TxtDepartamento.setText(rs.getString(3));
                TxtKilometraje.setText(rs.getString(4));
            }
        }
    }
    
    public void Combo_LoadProductos (JComboBox combo) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        combo.removeAllItems();
        ListProducts.clear();

        coneccion = new Conexion();
        ResultSet rs = coneccion.Consulta("SELECT codebar, nombre FROM products order by nombre asc");

        combo.addItem("PRODUCTOS & SERVICIOS");
        ListProducts.add("0");

        while (rs.next())
        {
            ListProducts.add(rs.getString(1));
            combo.addItem(rs.getString(2));
        }
    }
    
    public void Table_LoadProductsServicio(JTable t)
    {
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        t.setModel(modelo);

        modelo.addColumn("CODEBAR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");

        StyleJtable(t);
    }
    
    public void Table_AddProductsServicio(JTable t, JComboBox c, JLabel total) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
        if (c.getSelectedIndex() > 0)
        {
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT codebar, nombre, precio FROM products where codebar = '"+ListProducts.get(c.getSelectedIndex())+"' ");

            if (rs.next())
            {
                DefaultTableModel temp = (DefaultTableModel) t.getModel();
                Object nuevo[]= {rs.getString(1),rs.getString(2),rs.getDouble(3)};
                total.setText(String.valueOf(Double.parseDouble(total.getText()) + rs.getDouble(3)));
                temp.addRow(nuevo);
            }
        }
    }
    
    public void GenerateReporte_Service (JTable t_client, JTable t_vehiculos, int open, String S_solicitad, String S_realizado, JTable t_productos, String Total, String Prioridad)
    {
        Document documento = new Document(PageSize.LETTER,10,10,10,10);  
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
            
            
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.scaleToFit(200, 100);
            
            String membrete = "REPORTE DE SERVICIO"+ "\n\n";
            membrete += ReturnDatosFisicos(this.Datos_Nombre) + "\n";
            membrete += "DIRECCION: " + ReturnDatosFisicos(this.Datos_Direccion) + "\n";
            membrete += "RFC: " + ReturnDatosFisicos(this.Datos_Rfc)+"\n";
            membrete += "TELEFONO: " + ReturnDatosFisicos(this.Datos_Telefono) + "\n";
            membrete += "GENERO DOCUMENTO: " + ReturnNombreUsuario()+ "\n";
            membrete += "GENERADO: " + GetFechaAndHourActual()+ "\n";
            
            PdfPTable HeaderDatos = new PdfPTable(2);
            HeaderDatos.setWidthPercentage(100);
            
            documento.add(new Paragraph("\n"));
            
            PdfPCell cell = new PdfPCell(new Phrase(membrete));
            cell.setBorder(0);
            HeaderDatos.addCell(cell);
            cell = new PdfPCell(imagen);
            cell.setBorder(0);
            cell.setHorizontalAlignment(1);
            cell.setVerticalAlignment(1);
            HeaderDatos.addCell(cell);
        
            documento.add(HeaderDatos);
            documento.add(new Paragraph("\n"));
            /////////
            
            //Tabla_Clientes
            String Client_header = "CLIENTE";
            Paragraph Title = new Paragraph(Client_header.toUpperCase());
            Title.setAlignment(1);
            documento.add(Title);
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(t_client.getColumnCount());
            
            tabla.setWidthPercentage(100);
            
            for (int i = 0; i < t_client.getColumnCount(); i++)
            {
                Paragraph header = new Paragraph(t_client.getColumnName(i));
                header.setAlignment(1);
                tabla.addCell(header);
            }
            
            for (int i = 0; i < t_client.getRowCount(); i++)
            {
                for (int a = 0; a < t_client.getColumnCount(); a++)
                {
                    
                    Paragraph campo = new Paragraph(String.valueOf(t_client.getValueAt(i, a)));
                    campo.setAlignment(1);
                    tabla.addCell(campo);
                }
            }
            
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            
            //Tabla_Vehiculos
            String Vehiculos_header = "VEHICULO";
            
            Paragraph Title1 = new Paragraph(Vehiculos_header.toUpperCase());
            Title1.setAlignment(1);
            documento.add(Title1);
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla_vehiculos = new PdfPTable(t_vehiculos.getColumnCount());
            
            tabla_vehiculos.setWidthPercentage(100);
            
            for (int i = 0; i < t_vehiculos.getColumnCount(); i++)
            {
                Paragraph header = new Paragraph(t_vehiculos.getColumnName(i));
                header.setAlignment(1);
                tabla_vehiculos.addCell(header);
            }
            
            for (int i = 0; i < t_vehiculos.getRowCount(); i++)
            {
                for (int a = 0; a < t_vehiculos.getColumnCount(); a++)
                {
                    
                    Paragraph campo = new Paragraph(String.valueOf(t_vehiculos.getValueAt(i, a)));
                    campo.setAlignment(1);
                    tabla_vehiculos.addCell(campo);
                }
            }
            
            documento.add(tabla_vehiculos);
            documento.add(new Paragraph("SERVICIO SOLICITADO: " + S_solicitad.toUpperCase()));
            documento.add(new Paragraph("SERVICIO REALIZADO: "+ S_realizado.toUpperCase()));
            documento.add(new Paragraph("PRIORIDAD: "+ Prioridad));
            
            //Tabla de servicios y productos
            String Service_header = "\nSERVICIOS Y PRODUCTOS UTILIZADOS";
            
            Paragraph Title2 = new Paragraph(Service_header.toUpperCase());
            Title2.setAlignment(1);
            documento.add(Title2);
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla_PRODUCTS = new PdfPTable(t_productos.getColumnCount());
            
            tabla_PRODUCTS.setWidthPercentage(100);
            
            for (int i = 0; i < t_productos.getColumnCount(); i++)
            {
                Paragraph header = new Paragraph(t_productos.getColumnName(i));
                header.setAlignment(1);
                tabla_PRODUCTS.addCell(header);
            }
            
            for (int i = 0; i < t_productos.getRowCount(); i++)
            {
                for (int a = 0; a < t_productos.getColumnCount(); a++)
                {
                    
                    Paragraph campo = new Paragraph(String.valueOf(t_productos.getValueAt(i, a)));
                    campo.setAlignment(1);
                    tabla_PRODUCTS.addCell(campo);
                }
            }
            
            documento.add(tabla_PRODUCTS);
            documento.add(new Paragraph(""));
            //
            
            documento.add(new Paragraph("COSTO TOTAL DE SERVICIO $ "+ Total));
            documento.add(new Paragraph("FECHA Y HORA DE ENTREGA: ____________________________________________________"));
            documento.add(new Paragraph("NOMBRE Y FIRMA DEL QUE REALIZA: _____________________________________________"));
            documento.add(new Paragraph("CONFORMIDAD, NOMBRE Y FIRMA DE QUIEN RECIBE: _______________________________"));
            documento.add(new Paragraph("PROXIMO SERVICIO: ___________________________________________________________"));
            
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
    }
    
    public void Table_LoadClient(JTable t, JComboBox c)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("RFC");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT nombre, direccion, telefono, rfc FROM clients where id = "+ListClients.get(c.getSelectedIndex())+" ");
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
    
    public void Table_LoadCar(JTable t, JComboBox c)
    {
        try {
            DefaultTableModel modelo;
            modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            t.setModel(modelo);
            
            modelo.addColumn("MODELO");
            modelo.addColumn("COLOR");
            modelo.addColumn("PLACAS");
            modelo.addColumn("KILOMETRAJE");
            
            coneccion = new Conexion();
            ResultSet rs = coneccion.Consulta("SELECT mtp, color, placas, kilometros FROM vehiculos where placas = '"+ListVehiculos.get(c.getSelectedIndex())+"' ");
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
}
