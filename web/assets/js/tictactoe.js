$(function() {
    var lastCellPlayedByComputer = $('.ttt-table td.ttt-computer-cell-played .ttt-computer');
    if (lastCellPlayedByComputer.length != 0) {
        lastCellPlayedByComputer.hide();
        lastCellPlayedByComputer.fadeIn(800);
    }

});