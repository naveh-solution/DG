
import java.io.File;

import javax.sound.midi.*;
import javax.sound.midi.spi.*;
import javax.sound.midi.Track;


public class MainDG{
	
	
	public static final int NOTE_ON=0x90;
	public static final int note_off=0x80;
	public static final String[]note_name={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
	public static final int mat1[][]=new int[6][16];
	public static int[] Locarry;
	
	
	public static void main(String[] args) throws Exception{
		
		
		Sequence s1= MidiSystem.getSequence(new File("c:/midi/s6.mid"));
		for(Track song: s1.getTracks())
		{
			if(song.size()>4)
			{
				Locarry=new int[song.size()];
				Break_Solo locNote = new Break_Solo();
				Locarry=locNote.BreakSolo(song);
			}
		}
		
		for(int i=0;i<Locarry.length;i++)
			System.out.print(Locarry[i]+",");
		System.out.println();
	}
		
}


