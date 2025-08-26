package module05.tutorial1;

public class Main {

    public static void main(String[] args) {
        Computer musicPlayer = new Computer();
        runMusic(new Computer());
        runVideo(new Computer());
    }

    public static void runVideo(VideoPlayer videoPlayer){
        videoPlayer.playVideo();
    }

    public static void runMusic(MusicPlayer musicPlayer){
        musicPlayer.playMusic();
    }

}
