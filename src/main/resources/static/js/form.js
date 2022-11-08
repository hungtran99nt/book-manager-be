'use strict'

$(document).ready(function () {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }
            form.classList.add('was-validated')
        }, false)
    })

    const invalidFeedbackCode = document.getElementById('invalidFeedbackCode');
    const formInputBookCode = document.getElementById('formInputBookCode');
    formInputBookCode.addEventListener('change', function () {
        this.classList.remove("is-invalid");
        this.setCustomValidity("");
    }, false);
    formInputBookCode.addEventListener('input', function () {
        this.classList.remove("is-invalid");
        this.classList.remove("is-valid");
        this.setCustomValidity("");
    }, false);

    formInputBookCode.addEventListener('input', debounce(async (event) => {
        await checkExistsBookCode(event.target.value)
            .then(
                () => {
                    formInputBookCode.classList.add("is-valid");
                    formInputBookCode.classList.remove("is-invalid");
                    formInputBookCode.setCustomValidity("");
                },
                () => {
                    formInputBookCode.classList.add("is-invalid");
                    formInputBookCode.classList.remove("is-valid");
                    formInputBookCode.setCustomValidity("invalid");
                    invalidFeedbackCode.innerHTML = 'Book code exists'
                })
    }))
})

async function checkExistsBookCode(code) {
    if (code.length === 0) return Promise.resolve();
    await fetch(`http://localhost:8080/v1/books/${code}/exist`, {method: 'GET'})
        .then((res) => {
            if (!res.ok) return Promise.reject();
            else return Promise.resolve();
        })
}

function debounce(func, timeout = 300) {
    let timer;
    return (...args) => {
        clearTimeout(timer);
        timer = setTimeout(() => {
            func.apply(this, args);
        }, timeout);
    };
}