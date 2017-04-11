/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class Funciones {
       
    public ReturnProperties p = new ReturnProperties();
    
    public static int idClient = 0;
    
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
}
