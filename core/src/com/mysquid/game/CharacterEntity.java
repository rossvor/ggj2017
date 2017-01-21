package com.mysquid.game;

import com.badlogic.gdx.files.FileHandle;

import squidpony.squidmath.Coord;

public class CharacterEntity {
	private Wave waveSignature;
	private int BP,GP;
	private Coord position;
	private String name;
	private String description;
	
	public void setBP(int bp)
	{
		BP = bp;
	}
	
	public int getBP()
	{
		return BP;
	}
	
	public void setGP(int gp)
	{
		GP = gp;
	}
	
	public int getGP()
	{
		return GP;
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
	public CharacterEntity(int GP, int BP)
	{
		//setName(dataArr[0]);
		//setDescription(dataArr[1]);
		setGP(GP);
		setBP(BP);
		//setPosition(Coord.get(Integer.parseInt(dataArr[3]), Integer.parseInt(dataArr[4])));
	}
	
}
