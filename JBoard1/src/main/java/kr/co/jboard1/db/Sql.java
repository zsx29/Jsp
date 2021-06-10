package kr.co.jboard1.db;

public class Sql {
	
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(`email`) FROM `JBOARD_MEMBER` WHERE `email`=?";
	public static final String SELECT_COUNT_HP    = "SELECT COUNT(`hp`)    FROM `JBOARD_MEMBER` WHERE `hp`=?";
	public static final String SELECT_COUNT_NICK  = "SELECT COUNT(`nick`)  FROM `JBOARD_MEMBER` WHERE `nick`=?";              
	public static final String SELECT_COUNT_UID   = "SELECT COUNT(`uid`)   FROM `JBOARD_MEMBER` WHERE `uid`=?";
	
	public static final String SELECT_MEMBER   = "SELECT * FROM `JBOARD_MEMBER` WHERE `uid`=? AND `pass`=PASSWORD(?)";
	public static final String INSERT_MEMBER   = "INSERT INTO `JBOARD_MEMBER` SET "
												+ "`uid`=?,"
												+ "`pass`=PASSWORD(?),"
												+ "`name`=?,"
												+ "`nick`=?,"
												+ "`email`=?,"
												+ "`hp`=?,"
												+ "`zip`=?,"
												+ "`addr1`=?,"
												+ "`addr2`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW()";
	
	public static final String SELECT_TERMS   = "SELECT * FROM `JBOARD_TERMS`";
	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `JBOARD_ARTICLE`";
	public static final String INSERT_FILE    = "INSERT INTO `JBOARD_FILE` SET `parent`=?, `oriName`=?, `newName`=?, `rdate`=NOW();";
	public static final String INSERT_ARTICLE = "INSERT INTO `JBOARD_ARTICLE` SET "
												+ "`title`=?,"
												+ "`content`=?,"
												+ "`file`=?,"
												+ "`uid`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW()";
	
	
		
}