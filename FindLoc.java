
import java.io.File;

import javax.sound.midi.*;
import javax.sound.midi.spi.*;
import javax.sound.midi.Track;


public class FindLoc {
	public static int  Neck[][]={
        {404, 414, 424, 434, 444, 454, 464, 474, 485, 495, 505, 515, 525, 535, 545, 555},
        {454, 464, 474, 485, 495, 505, 515, 525, 535, 545, 555, 565, 575, 585, 595, 606},
        {505, 515, 525, 535, 545, 555, 565, 575, 585, 595, 606, 616, 626, 636, 646, 656},
        {555, 565, 575, 585, 595, 606, 616, 626, 636, 646, 656, 666, 676, 686, 696, 706},
        {595, 606, 616, 626, 636, 646, 656, 666, 676, 686, 696, 706, 716, 727, 737, 747},
        {646, 656, 666, 676, 686, 696, 706, 716, 727, 737, 747, 757, 767, 777, 787, 797}};
	
	private static int[] NoteLoc=new int[2];
	private static int Center=20;
	private static int NextNote;
	private static int Sfret=Center; //start point of the mat
	private static int Efret=Center; //end of mat 
	private static int Scheck;
	private static int String;
	private static int Counter=0;
	                                            //start of geters and seters for variables


	public static int getCenter() {
		return Center;
	}
	
	public static void setCenter(int center) {
		if(center==0||center==15)
			SetCenter(center);
		else
		Sfret=Efret=Center = center;
		
	}
	
	public static int getNextNote() {
		return NextNote;
	}
	
	public static void setNextNote(int nextNote) {
		NextNote = nextNote;
	}
	                                            //end of geters and seters for variables
	 
	
	public static void SetCenter(int center) //set the center fret when needed
	{
		if(center==0)
			Sfret=Efret=Center=1;
		if(center==15)
			Sfret=Efret=Center=14;
	}
	
	public static void FindNewCenter(int Fret){
		Center = Fret;
	}
	
/*	{
		if(String==5)
			String=4;
		if(String==0)
			String=1;
		
		int LastString,Fret;
		
		
		
		for(LastString=String-1;LastString<String+1;LastString++)
		{
			for(Fret=0;Fret<16;Fret++)
			{
				if(NextNote==Neck[LastString][Fret])
				{
					setCenter(Fret);
					NoteLoc[0]=LastString;
					NoteLoc[1]=Fret;
					return NoteLoc;
				}
			}
		}
		
		return NoteLoc;
	}*/
	
	
	public static int[] FirstSerch(int nextNote) //Search for the location of the note in the neck in the center mat
	{
		if(Sfret>0)
		Sfret=Sfret-1;
		if(Efret<15)
		Efret=Efret+1;
	   
	   for(String=0;String<6;String++)
	   {
		   for(Scheck=Sfret;Scheck<=Efret;Scheck++)
		   {
			   if(nextNote==Neck[String][Scheck])
			   {
				   NoteLoc[0]=String;
				   NoteLoc[1]=Scheck;
				      if(Counter >=2)
				      {
				    	  FindNewCenter(Scheck);
				    	  Counter=0;
				      }
				   return NoteLoc;
			   }
		   }
		   
	   }
	   Counter++;
	   if (Counter <8)
	   return FirstSerch(nextNote);
	
	   return NoteLoc;
	}
	
	public  int[] FindNoteLoc(int NoteToFind)
	{
		int[] temp=new int[2];
		temp=FirstSerch(NoteToFind);
		return temp;
	}
	
	
	

}

