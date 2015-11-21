import java.util.ArrayList;
public class MockMp3Player implements Mp3Player {

  private ArrayList<String> songList = new ArrayList<String>();
  private boolean playing = false;
  private int currSong = 0;
  private double currPos = 0.0;
  
  public void play(){
    playing = true;
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
    currSong++;
  }

  public void prev(){
    currSong--;
  }

  public boolean isPlaying(){
    return playing;
  }

  public void loadSongs(ArrayList names){
    songList = names;
  }

}
