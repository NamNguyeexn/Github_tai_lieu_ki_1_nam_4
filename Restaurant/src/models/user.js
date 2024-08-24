var EntitySchema = require("typeorm").EntitySchema

module.exports = new EntitySchema({
    name: "User", // Will use table name `category` as default behaviour.
    tableName: "users", // Optional: Provide `tableName` property to override the default behaviour for table name.
    columns: {
        id: {
            primary: true,
            type: "int",
            generated: true,
        },
        name: {
            nullable: false,
            type: "varchar",
        },
        address: {
            nullable: false,
            type: "varchar"
        },
        phone: {
            nullable: false,
            type: "int"
        },
        email: {
            nullable: false,
            type: "varchar"
        },
        username: {
            nullable: false,
            type: "varchar"
        },
        password: {
            nullable: false,
            type: "varchar"
        },
        role: {
            nullable: false,
            type: "varchar"
        },
    },
})