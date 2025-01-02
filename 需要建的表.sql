-- checkedSaleDraft
-- btypeaddress
-- stockAlerts


--// =================== checkedSaleDraft ==================== //

/*
 Navicat Premium Data Transfer

 Source Server         : 管家婆
 Source Server Type    : SQL Server
 Source Server Version : 8002039
 Source Host           : 192.168.1.19:1433
 Source Catalog        : HGWJ
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 8002039
 File Encoding         : 65001

 Date: 25/12/2023 09:16:26
*/


-- ----------------------------
-- Table structure for checkedSaleDraft
-- ----------------------------
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[checkedSaleDraft]') AND type IN ('U'))
	DROP TABLE [dbo].[checkedSaleDraft]
GO

CREATE TABLE [dbo].[checkedSaleDraft] (
  [dlyorder] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [etypeid] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [ptypeid] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [btypeid] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [ktypeid] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [vchcode] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [qty] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [price] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [deleted] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [date] datetime  NULL,
  [modified] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL
)
GO


-- ----------------------------
-- Indexes structure for table checkedSaleDraft
-- ----------------------------
CREATE NONCLUSTERED INDEX [_WA_Sys_etypeid_31A2B7F7]
ON [dbo].[checkedSaleDraft] (
  [etypeid] ASC
)
GO

CREATE NONCLUSTERED INDEX [_WA_Sys_date_31A2B7F7]
ON [dbo].[checkedSaleDraft] (
  [date] ASC
)
GO

CREATE NONCLUSTERED INDEX [_WA_Sys_dlyorder_31A2B7F7]
ON [dbo].[checkedSaleDraft] (
  [dlyorder] ASC
)
GO

CREATE NONCLUSTERED INDEX [_WA_Sys_ptypeid_31A2B7F7]
ON [dbo].[checkedSaleDraft] (
  [ptypeid] ASC
)
GO


--// ================== btypeaddress ================== //

/*
 Navicat Premium Data Transfer

 Source Server         : 管家婆
 Source Server Type    : SQL Server
 Source Server Version : 8002039
 Source Host           : 192.168.1.19:1433
 Source Catalog        : HGWJ
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 8002039
 File Encoding         : 65001

 Date: 25/12/2023 09:16:12
*/


-- ----------------------------
-- Table structure for btypeaddress
-- ----------------------------
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[btypeaddress]') AND type IN ('U'))
	DROP TABLE [dbo].[btypeaddress]
GO

CREATE TABLE [dbo].[btypeaddress] (
  [btypeid] varchar(25) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [bfullname] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [longitude] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [latitude] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [mapname] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [entryemployee] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [updatetime] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO


-- ----------------------------
-- Indexes structure for table btypeaddress
-- ----------------------------
CREATE NONCLUSTERED INDEX [_WA_Sys_longitude_14125510]
ON [dbo].[btypeaddress] (
  [longitude] ASC
)
GO


-- ----------------------------
-- Primary Key structure for table btypeaddress
-- ----------------------------
ALTER TABLE [dbo].[btypeaddress] ADD CONSTRAINT [PK__btypeaddress__15067949] PRIMARY KEY CLUSTERED ([btypeid])
ON [PRIMARY]
GO


--// =================== stockAlerts ==================== //
/*
 Navicat Premium Data Transfer

 Source Server         : 管家婆
 Source Server Type    : SQL Server
 Source Server Version : 8002039
 Source Host           : 192.168.1.19:1433
 Source Catalog        : HGWJ
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 8002039
 File Encoding         : 65001

 Date: 28/12/2024 11:42:54
*/


-- ----------------------------
-- Table structure for stockAlerts
-- ----------------------------
IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[stockAlerts]') AND type IN ('U'))
	DROP TABLE [dbo].[stockAlerts]
GO

CREATE TABLE [dbo].[stockAlerts] (
  [ptypeid] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [ktypeid] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [minimum] int  NULL
)
GO


-- ----------------------------
-- Indexes structure for table stockAlerts
-- ----------------------------
CREATE NONCLUSTERED INDEX [_WA_Sys_ptypeid_58BC8518]
ON [dbo].[stockAlerts] (
  [ptypeid] ASC
)
GO

CREATE NONCLUSTERED INDEX [_WA_Sys_ktypeid_58BC8518]
ON [dbo].[stockAlerts] (
  [ktypeid] ASC
)
GO


