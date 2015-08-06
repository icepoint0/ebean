package com.avaje.ebean.dbmigration.ddlgeneration.platform;

import com.avaje.ebean.config.dbplatform.DbIdentity;
import com.avaje.ebean.config.dbplatform.DbTypeMap;

/**
 * MS SQL Server platform specific DDL.
 */
public class MsSqlServerDdl extends PlatformDdl {

  public MsSqlServerDdl(DbTypeMap platformTypes, DbIdentity dbIdentity) {
    super(platformTypes, dbIdentity);
    this.identitySuffix = " generated by default as identity";
  }

//  /**
//   * MS SQL Server specific DDL Syntax.
//   */
//  public class MsDdlSyntax extends DbDdlSyntax {
//
//    MsDdlSyntax() {
//      this.identity = "identity(1,1)";
//      this.dropKeyConstraints = true;
//    }
//
//    /**
//     * Return some DDL to disable constraints on the given table.
//     */
//    public String dropKeyConstraintPrefix(String tableName, String fkName) {
//      return "IF OBJECT_ID('"+fkName+"', 'F') IS NOT NULL";
//    }
//
//    /**
//     * Return prefix text that goes before drop table.
//     */
//    public String dropTablePrefix(String tableName) {
//      return "IF OBJECT_ID('"+tableName+"', 'U') IS NOT NULL ";
//    }
//
//  }
}