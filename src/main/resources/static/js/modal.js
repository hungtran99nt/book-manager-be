'use strict'

$(document).ready(function () {
    const deleteButtons = document.querySelectorAll('.btn.btn-danger');
    const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');
    const modalBody = document.getElementsByClassName('modal-body');

    Array.from(deleteButtons).forEach(btn => {
        btn.addEventListener("click", () => {
            console.log('asdfasdf')
            modalBody[0].innerHTML = `Do you want to delete ${btn.title}?`;
            confirmDeleteBtn.setAttribute('href', `http://localhost:8080/v2/books/${btn.id}/delete`);
        })
    })
})