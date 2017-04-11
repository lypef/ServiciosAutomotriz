package clases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author lypef
 */
public class ReturnProperties {
    public String nombre_db = "nombre_db";
    public String ruta_db = "ruta_db";
    public String usuario_db = "usuario_db";
    public String passwors_db = "passwors_db";
    public String puerto_db = "puerto_db";
    public String Ruta_logo = "ruta_logo";
    public String Table_FondHeader = "TableFonfHeader";
    public String Table_FondZiseHeader = "TableFondZiseHeader";
    public String Table_HeaderBold = "TableFondHeaderBold";
    public String Table_BodyBold = "TableFondBodyBold";
    public String Table_FondBody = "TableFondBody";
    public String Table_FondZiseBody = "TableFondZiseBody";
    
    
            
            
                    
                    
                    
    public String ReturnPropiedad (String propiedad)
    {
        Properties propiedades = new Properties();
        
        try {
            
            InputStream FileConfig = null;
            File path = new File (".");
            FileConfig = new FileInputStream(path.getCanonicalPath() + "/config.properties");
            propiedades.load(FileConfig);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return propiedades.getProperty(propiedad);
    }
    
    public String ReturnMinuscula (String propiedad) throws FileNotFoundException, IOException
    {
        Properties propiedades = new Properties();
        
        try {
            
            InputStream FileConfig = null;
            File path = new File (".");
            FileConfig = new FileInputStream(path.getCanonicalPath() + "/config.properties");
            propiedades.load(FileConfig);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return propiedades.getProperty(propiedad).toLowerCase();
    }
    
    public String ReturnMayuscula (String propiedad) throws FileNotFoundException, IOException
    {
        Properties propiedades = new Properties();
        
        try {
            
            InputStream FileConfig = null;
            File path = new File (".");
            FileConfig = new FileInputStream(path.getCanonicalPath() + "/config.properties");
            propiedades.load(FileConfig);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return propiedades.getProperty(propiedad).toUpperCase();
    }
    
    public int ReturnINT (String propiedad) throws FileNotFoundException, IOException
    {
        Properties propiedades = new Properties();
        
        try {
            
            InputStream FileConfig = null;
            File path = new File (".");
            FileConfig = new FileInputStream(path.getCanonicalPath() + "/config.properties");
            propiedades.load(FileConfig);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Integer.parseInt(propiedades.getProperty(propiedad));
    }
}
