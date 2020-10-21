const fs = require('fs')

fs.readFile(process.argv[1], 'utf8', (error, data) => {
    if (error) {
        return console.error(error);
    }
    const result = data.replaceAll(process.argv[2], process.argv[3]);
    fs.writeFile(process.argv[1], result, 'utf8', (error) => {
        if (error) {
            return console.error(error);
        }
    });
});