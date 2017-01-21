package com.mysquid.game;
import java.io.BufferedReader;
import java.io.IOException;

import com.badlogic.gdx.files.FileHandle;

public class MapLoader {


public char[][] LoadMap(FileHandle MapFile)
{
	char[][] map = new char[80][24];
	
	
		String data = MapFile.readString();
		//System.out.println(MapFile.readString());
		String[] dataArr = data.split(",");
		int row = 0;
		
		
	BufferedReader in = MapFile.reader(2000);
	try {
		while ((data = in.readLine())!=null)
		{
			dataArr = data.split(",");
			for (int col=0;col<=79;col++)
			{
				map[col][row] = dataArr[col].charAt(0);
			}
			row++;
		}
		in.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return map;
	
}


}