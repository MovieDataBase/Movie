if exists (select 1
            from  sysobjects
           where  id = object_id('"browse"')
            and   type = 'U')
   drop table "browse"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('comment')
            and   type = 'U')
   drop table comment
go

if exists (select 1
            from  sysobjects
           where  id = object_id('direct')
            and   type = 'U')
   drop table direct
go

if exists (select 1
            from  sysobjects
           where  id = object_id('director')
            and   type = 'U')
   drop table director
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"like"')
            and   type = 'U')
   drop table "like"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('movie')
            and   type = 'U')
   drop table movie
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"user"')
            and   type = 'U')
   drop table "user"
go

if exists (select 1
   from  sysobjects where type = 'D'
   and name = 'time'
   )
   drop default time
go

/*==============================================================*/
/* Default: time                                                */
/*==============================================================*/
create default time
    as
go

/*==============================================================*/
/* Table: "browse"                                              */
/*==============================================================*/
create table "browse" (
   browseid             int                  identity,
   userid               int                  not null,
   movieid              int                  not null,
   browsetime           datetime             not null default getdate(),
   constraint PK_BROWSE primary key nonclustered (browseid)
)
go

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment (
   commentid            int                  identity,
   userid               int                  not null,
   movieid              int                  not null,
   text                 varchar(1000)        not null,
   time                 datetime             not null default getdate(),
   score                int                  not null,
   constraint PK_COMMENT primary key nonclustered (commentid),
   constraint AK_USERID_COMMENT unique (userid, movieid)
)
go

/*==============================================================*/
/* Table: direct                                                */
/*==============================================================*/
create table direct (
   directorid           int                  not null,
   movieid              int                  not null,
   constraint PK_DIRECT primary key nonclustered (directorid, movieid)
)
go

/*==============================================================*/
/* Table: director                                              */
/*==============================================================*/
create table director (
   directorid           int                  identity,
   name                 varchar(100)         not null,
   sex                  varchar(10)          not null,
   birthday             datetime             not null,
   birthplace           varchar(100)         not null,
   profile              varchar(2000)        not null,
   constraint PK_DIRECTOR primary key nonclustered (directorid)
)
go

/*==============================================================*/
/* Table: "like"                                                */
/*==============================================================*/
create table "like" (
   userid               int                  not null,
   commentid            int                  not null,
   constraint PK_LIKE primary key nonclustered (userid, commentid)
)
go

/*==============================================================*/
/* Table: movie                                                 */
/*==============================================================*/
create table movie (
   movieid              int                  identity,
   moviename            varchar(100)         not null,
   screenwriter         varchar(500)         not null,
   actor                varchar(1000)        not null,
   type                 varchar(50)          not null,
   country              varchar(100)         not null,
   language             varchar(50)          not null,
   releasetime          datetime             not null,
   duration             int                  not null,
   introduction         varchar(2000)        not null,
   constraint PK_MOVIE primary key nonclustered (movieid)
)
go

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" (
   userid               int                  identity,
   username             varchar(20)          not null,
   password             varchar(20)          not null,
   email                varchar(50)          not null,
   constraint PK_USER primary key nonclustered (userid),
   constraint AK_USERNAME_USER unique (username)
)
go
