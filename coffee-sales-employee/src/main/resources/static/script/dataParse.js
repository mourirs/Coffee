function parseParams(data) {
    try {
        let tempArr = [];
        for (let i in data) {
            let key = encodeURIComponent(i);
            let value = encodeURIComponent(data[i]);
            tempArr.push(key + '=' + value);
        }
        return tempArr.join('&');
    } catch (err) {
        return '';
    }
}