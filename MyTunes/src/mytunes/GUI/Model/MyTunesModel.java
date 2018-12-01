/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI.Model;

import java.io.File;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import mytunes.BLL.MyTunesManager;
import mytunes.BLL.SongSearcher;
import mytunes.be.Song;

/**
 *
 * @author bonde
 */
public class MyTunesModel
{
//    final JFXPanel fxPanel = new JFXPanel();
    private ListView<Song> listSearch;
    private MediaPlayer mediaPlayer;
    private final SongSearcher ss;
    private MyTunesManager mtm;
    private String trueTrueFilePath;
//    Media media = new Media(new File(filePath).toURI().toString());
//    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    public MyTunesModel() {
        ss = new SongSearcher();
        mtm = new MyTunesManager();
    }
    
    
    public void initializeFile()
    {
        String filePath;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File (*.mp3)", "*.mp3");
            fileChooser.getExtensionFilters().add(filter);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                filePath = file.toURI().toString();
                String trueFilePath = filePath.replaceFirst("file:/", "");
                trueTrueFilePath = trueFilePath.replace("%20", " ");
                
            }else {
                System.out.println("No file chosen");
                
            }
    }
    
    public void playMusic()
    {
        mediaPlayer.play();
    }
    
    public void stopMusic()
    {
        mediaPlayer.stop();
    }
    
    public void pauseMusic()
    {
        mediaPlayer.pause();
    }
    
    public void endApplication()
    {
        System.exit(0);
    }
    
    public void deleteSong()
    {
        
    }
    
    public void searchSong()
    {
        
    }
    
    public String getSongTitle() {
        String songTitle = mtm.getSongTitle(trueTrueFilePath);
        if (!songTitle.isEmpty() || !songTitle.equals(null)) {
            return songTitle;
        }else {
        return "This song has no current title";
        }
    }
    
    public String getDuration() {
        String duration = Integer.toString(mtm.getDurationInSec(trueTrueFilePath));
        return duration;
    }
    
    public String getFilePath() {
        return trueTrueFilePath;
    }
    
    public String getArtist() {
        String artist = mtm.getAuthor(trueTrueFilePath);
        return artist;
    }
    
    
//    public void searchWrite()
//    {
//        listSearch.getItems().clear();
//        listSearch.getItems().addAll(ss.searchSongs(writeSearch.getText().toLowerCase()));
//    }
}
