var connectDB = new typeorm.connectDB({
    // type: "postgres",
    host: "localhost",
    port: 3306,
    username: "root",
    password: "011002",
    database: "restaurant",
    synchronize: true,
    entities: ['src/**/*.models{.ts,.js}']
    // entities: [
    //     require("./models/Post"), 
    //     require("./models/Category")
    // ],
})