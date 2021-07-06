var crypto = require('crypto');
var algorithm = 'aes256'; // or any other algorithm supported by OpenSSL
var key = 'password';

const encrypt = (text) => {

    const cipher = crypto.createCipher(algorithm, key);

    return cipher.update(text, 'utf8', 'hex') + cipher.final('hex');
};

const decrypt = (hash) => {

    var decipher = crypto.createDecipher(algorithm, key);
    return decipher.update(encrypted, 'hex', 'utf8') + decipher.final('utf8');

};

module.exports = {
    encrypt,
    decrypt
};