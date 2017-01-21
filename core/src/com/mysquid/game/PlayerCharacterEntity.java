package com.mysquid.game;

import com.badlogic.gdx.files.FileHandle;

import squidpony.squidmath.Coord;

public class PlayerCharacterEntity {
	private Wave waveSignature;
	private int karma,BP;
	private Coord position;
	private String name;
	private String description;
	
	public void setKarma(int Karma)
	{
		karma = Karma;
	}
	
	public int getKarma()
	{
		return karma;
	}
	
	public void setBP(int bp)
	{
		BP = bp;
	}
	
	public int getBP()
	{
		return BP;
	}
	
	public void setPosition(Coord pos)
	{
		position = pos;
	}
	
	public Coord getPosition()
	{
		return position;
	}
	
	public void setName(String Name)
	{
		name = Name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDescription(String Description)
	{
		description = Description;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	/*public CharacterEntity(FileHandle Filename)
	{
		String data = Filename.readString();
		String[] dataArr = data.split(",");
		setName(dataArr[0]);
		setDescription(dataArr[1]);
		setHP(Integer.parseInt(dataArr[2]));
		setPosition(Coord.get(Integer.parseInt(dataArr[3]), Integer.parseInt(dataArr[4])));
	}*/
	public PlayerCharacterEntity(int Karma, int BP)
	{
		//setName(dataArr[0]);
		//setDescription(dataArr[1]);
		setKarma(Karma);
		setBP(BP);
		//setPosition(Coord.get(Integer.parseInt(dataArr[3]), Integer.parseInt(dataArr[4])));
	}
	
}
