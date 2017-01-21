package com.mysquid.game;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class MapLoader {


public char[][] LoadMap(FileHandle MapFile)
{
	char[][] map = new char[80][24];
	
	
		String data = MapFile.readString();
		System.out.println(MapFile.readString());
		String[] dataArr = data.split(",");
		int row = 0;
		
		/*for (int row = 0;row<=23;row++)
		{
			for (int col=0;col<=79;col++)
			{
				System.out.println(row+" "+col+" "+dataArr[realcol].charAt(0));
				map[col][row] = dataArr[realcol].charAt(0);
				realcol++;
			}
			
		}*/
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
