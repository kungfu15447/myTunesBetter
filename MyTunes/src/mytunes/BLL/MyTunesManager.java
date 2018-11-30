/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.BLL;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytunes.DAL.SongMetaData;
import org.farng.mp3.TagException;


import mytunes.DAL.SongMetaData;

/**
 *
 * @author bonde
 */
public class MyTunesManager
{
    private SongMetaData smd;
    public MyTunesManager() {
        smd = new SongMetaData();
    }
    
    public String getSongTitle(String filepath) {
        try
        {
            return smd.getSongTitle(filepath);
        } catch (IOException ex)
        {
            Logger.getLogger(MyTunesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex)
        {
            Logger.getLogger(MyTunesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getGenre(String filepath) {
        try
        {
            return smd.getGenre(filepath);
        } catch (IOException ex)
        {
            Logger.getLogger(MyTunesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex)
        {
            Logger.getLogger(MyTunesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getAuthor(String filepath) {
        try
        {
            return smd.getAuthor(filepath);
        } catch (IOException ex)
        {
            Logger.getLogger(MyTunesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex)
        {
            Logger.getLogger(MyTunesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public int getDurationInSec(String filepath) {
        return smd.getDurationInSec(filepath);
    }
}

