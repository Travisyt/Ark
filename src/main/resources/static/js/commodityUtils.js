function fUnitFormat(commodity, unitMap) {
    let unitString = '';
    let qty = parseInt(commodity.qty);
    if (typeof unitMap === 'undefined') {
        return '-';
    }
    if (qty === 0) {
        return '0'
    }
    let baseUnit = 1, secondUnit = parseInt(unitMap.secondRate),
        thirdUnit = parseInt(unitMap.thirdRate);
    let list = ['secondUnit', 'thirdUnit'], index = 0;
    eval(list[0]) > eval(list[1]) ? index = 1 : index = 0;
    let rest = qty;
    if (Math.abs(rest) >= eval(list[index])) {
        unitString = unitString.concat(parseInt(qty / eval(list[index])).toString()).concat(unitMap[list[index]]).concat(',');
        rest = qty % eval(list[index]);
    }
    if (Math.abs(rest) >= eval(list[1 - index])) {
        unitString = unitString.concat(parseInt(rest / eval(list[1 - index])).toString()).concat(unitMap[list[1 - index]]).concat(',');
        rest = rest % eval(list[1 - index]);
    }
    if (Math.abs(rest) > 0) {
        unitString = unitString.concat(rest.toString()).concat(unitMap.baseUnit).concat(',');
    }
    unitString = unitString.substr(0, unitString.length - 1);
    return unitString;
}

function getUnitRelation(unitMap) {
    if (typeof unitMap === 'undefined') {
        return '-';
    }
    let unitString = '';
    let trdFlag = false;
    let secR = '';
    let secU = '';
    let baseRate = '1';
    if (unitMap['thirdRate'] !== '') {
        unitString = unitString.concat('1').concat(unitMap['thirdUnit']).concat('=');
        baseRate = unitMap['thirdRate'].split('.')[0];
        trdFlag = true;
    }
    if (unitMap['secondRate'] !== '') {
        if (trdFlag) {
            secR = (parseInt(unitMap['thirdRate']) / parseInt(unitMap['secondRate'])).toString();
        } else {
            secR = '1';
            baseRate = unitMap['secondRate'].split('.')[0];
        }
        secU = unitMap['secondUnit'];
        unitString = unitString.concat(secR).concat(secU).concat('=');
    }
    unitString = unitString.concat(baseRate).concat(unitMap['baseUnit']);
    return unitString;
}