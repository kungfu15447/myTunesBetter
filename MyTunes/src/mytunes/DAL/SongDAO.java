    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.DAL;

import java.io.IOException;
import java.util.List;
import mytunes.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author J
 */
public class SongDAO
{   

    private final ConnectionDAO cb;
    
    public SongDAO() {
        cb = new ConnectionDAO();
    }
    
    public List<Song> getAllSongs() throws IOException
    {
    
    List<Song> songs = new ArrayList<>();
    
    try (Connection con = cb.getConnection())
    {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Song;");
        while(rs.next())
        {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            int duration = rs.getInt("duration");
            String author = rs.getString("author");
            String genre = rs.getString("genre");
            String filepath = rs.getString("filepath");
            Song song = new Song(id,title,duration,author,genre,filepath);
            songs.add(song);
                    
        }
    }
    catch (SQLException ex)
    {
        ex.printStackTrace();
    }
    return songs;
        
    }
    
    public Song createSong(String title, int duration, String author, String genre, String filepath) throws SQLException
    {
        String sql = "INSERT INTO Song (title,duration, author, genre, filepath) VALUES(?,?,?,?,?);";
        
        try (Connection con = cb.getConnection())
        {
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, title);
            st.setInt(2, duration);
            st.setString(3, author);
            st.setString(4, genre);
            st.setString(5, filepath);
            
            int rowsAffected = st.executeUpdate();
            
            ResultSet rs = st.getGeneratedKeys();
            int id = 0;
            if (rs.next())
            {
                id = rs.getInt(1);
            }
            Song song = new Song(id, title, duration, author, genre, filepath);
            return song;
        }
    }
}
