package com.mysquid.game;
import java.io.BufferedReader;
import java.io.IOException;

import squidpony.squidmath.Coord;

import com.badlogic.gdx.files.FileHandle;

public class MapLoader {
private String description;
private String NextMap;
private Coord PlayerStart;
private Coord CreatureStart;
private String waveValuesString;

public String getNextMap()
{
	return NextMap;
}

public Wave getRealmWave() {
	
	String[] values = waveValuesString.split(",");
	float[] waveValues = new float[30]; 
	
	for (int i=0; i<values.length; i++){ 
		waveValues[i] = Float.parseFloat(values[i]);
	}
	Wave wave = new Wave(waveValues);

	return wave;
	
}

public char[][] LoadMap(FileHandle MapFile)
{
	char[][] map = new char[80][24];
	
	
		String data = MapFile.readString();
		//System.out.println(MapFile.readString());
		String[] dataArr = data.split(",");
		int row = 0;
		
		
	BufferedReader in = MapFile.reader(2000);
	
	try {
		description = in.readLine();
		NextMap = in.readLine();
		waveValuesString = in.readLine();
		while ((data = in.readLine())!=null)
		{
			dataArr = data.split(",");
			for (int col=0;col<=79;col++)
			{
				System.out.println(row+" "+col);
				map[col][row] = dataArr[col].charAt(0);
				if (map[col][row]=='@')
				{
					PlayerStart = Coord.get(col, row);
					//System.out.println("PlayerStart "+col+" "+row);
					map[col][row]='.';
				}else
					if (map[col][row]=='C')
					{
						CreatureStart = Coord.get(col, row);
						//System.out.println("PlayerStart "+col+" "+row);
						map[col][row]='.';
					}
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

public Coord getPlayerStart()
{
	return PlayerStart;
}

public Coord getCreatureStart()
{
	return CreatureStart;
}

public String getDescription()
{
	return description;
}
}
