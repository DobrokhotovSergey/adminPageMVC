$.fn.serializeObject = function(){
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        //console.log('-->' + this.value.replace(/ /g,'') + '<--');
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value.replace(/ /g,'') || '');
        } else {
            o[this.name] = this.value.replace(/ /g,'') || '';
        }
    });
    return o;
};