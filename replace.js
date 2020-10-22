const fs = require('fs')

console.log(process.argv);
fs.readFile(process.argv[2], 'utf8', (error, data) => {
    if (error) {
        return console.error(error);
    }
    const result = data.replace(process.argv[3], process.argv[4])
        .replace(process.argv[3], process.argv[4])
        .replace(process.argv[3], process.argv[4])
        .replace(process.argv[3], process.argv[4])
        .replace(process.argv[3], process.argv[4]);
    fs.writeFile(process.argv[2], result, 'utf8', (error) => {
        if (error) {
            return console.error(error);
        }
    });
});