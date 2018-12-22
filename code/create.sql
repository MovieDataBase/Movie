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

/*==============================================================*/
/* Table: "browse"                                              */
/*==============================================================*/
create table "browse" (
   browseid             int                  not null,
   userid               int                  not null,
   movieid              int                  not null,
   broustime            datetime             not null,
   constraint PK_BROWSE primary key nonclustered (browseid)
)
go

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment (
   commentid            int                  not null,
   userid               int                  not null,
   movieid              int                  not null,
   text                 varchar(1000)        not null,
   time                 datetime             not null,
   score                int                  not null,
   constraint PK_COMMENT primary key nonclustered (commentid)
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
   directorid           int                  not null,
   name                 varchar(100)         not null,
   sex                  varchar(10)          not null,
   birthday             date                 not null,
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
   movieid              int                  not null,
   moviename            varchar(100)         not null,
   screenwriter         varchar(500)         not null,
   actor                varchar(1000)        not null,
   type                 varchar(50)          not null,
   country              varchar(100)         not null,
   language             varchar(50)          not null,
   releasetime          date                 not null,
   duration             int                  not null,
   introduction         varchar(2000)        not null,
   constraint PK_MOVIE primary key nonclustered (movieid)
)
go

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" (
   userid               int                  not null,
   username             varchar(20)          not null,
   password             varchar(20)          not null,
   email                varchar(50)          not null,
   constraint PK_USER primary key nonclustered (userid)
)
go
