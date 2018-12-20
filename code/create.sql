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
/* Table: comment                                               */
/*==============================================================*/
create table comment (
   commentid            char(20)             not null,
   userid               char(10)             not null,
   movieid              char(10)             not null,
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
   directorid           char(10)             not null,
   movieid              char(10)             not null,
   constraint PK_DIRECT primary key nonclustered (directorid, movieid)
)
go

/*==============================================================*/
/* Table: director                                              */
/*==============================================================*/
create table director (
   directorid           char(10)             not null,
   name                 varchar(100)         not null,
   sex                  varchar(10)          not null,
   birthday             datetime             not null,
   birthplace           varchar(100)         not null,
   profile              varchar(2000)        not null,
   constraint PK_DIRECTOR primary key nonclustered (directorid)
)
go

/*==============================================================*/
/* Table: movie                                                 */
/*==============================================================*/
create table movie (
   movieid              char(10)             not null,
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
   userid               char(10)             not null,
   username             varchar(20)          not null,
   password             varchar(20)          not null,
   email                varchar(50)          not null,
   constraint PK_USER primary key nonclustered (userid)
)
go
