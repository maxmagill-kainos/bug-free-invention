const mysql = require('mysql');
const dbconfig = require('./dbconfig.json');
const util = require ('util')
const db = wrapDB(dbconfig)


function wrapDB (dbconfig) {
    const pool = mysql.createPool(dbconfig)
    return {
        query(sql, args) {
            return util.promisify( pool.query )
            .call(pool, sql, args)
        },
        release () {
            return util.promisify( pool.releaseConnection )
            .call( pool )
        }
    }
}

exports.getJobRoles = async () => {
    return await db.query(
        "SELECT CONCAT(Band_Name, ' ', Job_Title) , Job_Spec, Band_Level"
        + "FROM teamC_Josh.Job JOIN teamC_Josh.Band"
        + "ON(teamC_Josh.Job.Band_ID = teamC_Josh.Band.Band_ID);"
    )
}


