# IOCProj14-MiniProject-RealTimeDI-looseCcouping
This project is a mini-application demonstrating the implementation of **Dependency Injection (DI)**, **Inversion of Control (IoC)**, and **Loose Coupling** principles using the Spring Core Framework, Java 17, and MySQL.   

[ Client / RealtimeDITest ]
          │
          ▼  (Passes Customer Model Data)
[ CustomerOperationController ]
          │
          ▼  (Injects Interface: ICustomerMgmtService)
[ ICustomerMgmtServiceImpl ] ───► (Calculates Discount & Final Amount)
          │
          ▼  (Injects Interface: ICustomerDAO via @Qualifier("db"))
[ CustomerMYSQLDAOImpl ]
          │
          ▼  (HikariCP DataSource Connection Pool)
[ MySQL Database (Spring_Customer_Info Table) ]
