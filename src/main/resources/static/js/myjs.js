var inst = new mdui.Dialog('#dialog_login');

// method
document.getElementById('button_login').addEventListener('click', function () {
    inst.open();
});


// event
var dialog = document.getElementById('dialog_login');

dialog.addEventListener('open.mdui.dialog', function () {
    console.log('open');
});

dialog.addEventListener('opened.mdui.dialog', function () {
    console.log('opened');
});

dialog.addEventListener('close.mdui.dialog', function () {
    console.log('close');
});

dialog.addEventListener('closed.mdui.dialog', function () {
    console.log('closed');
});

dialog.addEventListener('cancel.mdui.dialog', function () {
    console.log('cancel');
});

dialog.addEventListener('confirm.mdui.dialog', function () {
    console.log('confirm');
});

