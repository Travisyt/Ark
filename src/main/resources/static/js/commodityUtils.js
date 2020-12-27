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
    let trdR = parseInt(unitMap.thirdRate), secR = parseInt(unitMap.secondRate);
    let trd = '1'.concat(unitMap.thirdUnit), sec = (trdR / secR).toString().concat(unitMap.secondUnit);
    unitString.concat(trd).concat('=').concat(sec).concat('=').concat(unitMap.baseUnit);
    return unitString;
}