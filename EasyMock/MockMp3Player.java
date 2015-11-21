import java.util.ArrayList;
public class MockMp3Player implements Mp3Player {

  private ArrayList<String> songList = new ArrayList<String>();
  private boolean playing = false;
  private int currSong = 0;
  private double currPos = 0.0;
  
  public void play(){
    if(songList.size() > 0){
      playing = true;
      currPos += 0.1;
    }
  } 

  public void pause(){
    playing = false;
  }

  public void stop(){
    playing = false;
  }

  public double currentPosition(){
    return currPos;
  }

  public String currentSong(){
    return songList.get(currSong);
  }

  public void next(){
    if(currSong < (songList.size() - 1) ){
      currSong++;
    }
  }

  public void prev(){
    if(currSong > 0){
      currSong--;
    }
  }

  public boolean isPlaying(){
    return playing;
  }

  public void loadSongs(ArrayList names){
    songList = names;
  }

}
