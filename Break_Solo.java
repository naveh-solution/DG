
import java.io.File;

import javax.sound.midi.*;
import javax.sound.midi.spi.*;
import javax.sound.midi.Track;

public class Break_Solo extends MainDG {
	
	
	public static int[] locarr;
	
	public int[] BreakSolo(Track tsolo)
	{
		int [] temp=new int[2];
		
				locarr=new int[tsolo.size()];
				for(int i=1;i<tsolo.size();i++)
				{
					
					MidiEvent so1=tsolo.get(i);
					
					MidiMessage solp1=so1.getMessage();
			
					if(solp1 instanceof ShortMessage)
					{
						ShortMessage note1=(ShortMessage) solp1;
						
						int da1=note1.getData1();
						int NumToF=(da1*10)+((da1/12)+1);
						System.out.println(NumToF);
						
						if(note1.getCommand()==NOTE_ON)
						{
							
							FindLoc noteloc=new FindLoc();
							if(FindLoc.getCenter()>15 )
								FindLoc.setCenter(0);
							temp=noteloc.FindNoteLoc(NumToF);
							int templ=temp[0]*100;
							templ+=temp[1];
							locarr[i]=templ;
							System.out.println(temp[0]+","+temp[1]);
	
						}
						
					}
					
				}
		return locarr;
	}
}
