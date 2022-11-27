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

    const invalidFeedbackId = document.getElementById('invalidFeedbackId');
    const formInputEmployeeId = document.getElementById('formInputEmployeeId');
    formInputEmployeeId.addEventListener('change', function (event) {
        this.classList.remove("is-invalid");
        this.setCustomValidity("");
    }, false);
    formInputEmployeeId.addEventListener('input', function () {
        this.classList.remove("is-invalid");
        this.classList.remove("is-valid");
        this.setCustomValidity("");
    }, false);

    formInputEmployeeId.addEventListener('input', debounce(async (event) => {
        await checkExistsEmployeeId(event.target.value)
            .then(
                () => {
                    formInputEmployeeId.classList.add("is-valid");
                    formInputEmployeeId.classList.remove("is-invalid");
                    formInputEmployeeId.setCustomValidity("");
                },
                () => {
                    formInputEmployeeId.classList.add("is-invalid");
                    formInputEmployeeId.classList.remove("is-valid");
                    formInputEmployeeId.setCustomValidity("invalid");
                    invalidFeedbackId.innerHTML = 'Employee ID duplicates'
                })
    }))
})

async function checkExistsEmployeeId(id) {
    if (id.length === 0) return Promise.resolve();
    await fetch(`http://localhost:8080/v1/emps/${id}/exist`, {method: 'GET'})
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