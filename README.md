# Student
学生管理系统
项目基于JavaEE平台，B/S模式开发，系统大致采用6层架构设计:view(表示)层、control(控制转发)层、models(模型)层、interface(接口)层、service(业务逻辑)层、dao(持久)层，使用Spring,SpringMvc,Mybatis,MySQL, Ajax, xml,JavaScript,JavaBean。
表现层（springMVC）：Controller层（Handler层），负责具体的业务模块流程的控制Controller层通过要调用Service层的接口来控制业务流程，控制配置位于Spring配置文件。
业务层（Spring）：Service层：负责业务模块的逻辑应用设计。首先设计其接口，然后再实现他的实现类。通过对Spring配置文件中配置其实现的关联，完成此步工作，通过调用Service的接口来进行业务处理。最后通过调用DAO层已定义的接口，实现Service具体的实现类。
持久层（Mybatis）：Dao层（Mapper层）Dao层：负责与数据库进行交互设计，用来处理数据的持久化工作。DAO层的设计首先是设计DAO的接口，在Spring的配置文件中定义此接口的实现类，使用反射机制在其他模块中调用此接口来进行数据业务的处理，而不用关心接口的具体实现类是哪个类。DAO层的数据源配置，以及有关数据库连接的参数等在Spring的配置文件中进行配置。
