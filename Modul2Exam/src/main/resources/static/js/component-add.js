window.onload = function() {
    
    let producerId = document.querySelector("select[name=producerId]");
    let model = document.querySelector("input[name=model]");
    let date = document.querySelector("input[name=availabilityDate]");
    let price = document.querySelector("input[name=price]");
    
    
    let addButton = document.querySelectorAll("button");
    
    function validateProducerId() {
        return producerId.value > 0;
    }
    
    function validateModel() {
        return model.value != "";
    }
    
    function validateDate() {
        return new Date(date.value) >= new Date();
    }
    
    function validatePrice() {
        return Number(price.value) > 0;
    }
    
    function validate() {
        return validateProducerId() && validateModel() && validateDate() && validatePrice();
    }
    
    let producerCallback = function(event) {
        let error = event.target.nextElementSibling;
        error.textContent = validateProducerId() ? "" : "You must select a producer!";
    
        addButton.disabled = !validate();
    };
    producerId.onchange = producerCallback;
    producerId.onblur = producerCallback;
    producerId.onkeyup = producerCallback;
    
    let modelCallback = function(event) {
        let error = event.target.nextElementSibling;
        error.textContent = validateModel() ? "" : "You must enter a model!";
    
        addButton.disabled = !validate();
    };
    model.onchange = modelCallback;
    model.onblur = modelCallback;
    model.onkeyup = modelCallback;
    
    let dateCallback = function(event) {
        let error = event.target.nextElementSibling;
        error.textContent = validateDate() ? "" : "The date must be today or in the future!";
    
        addButton.disabled = !validate();
    };
    date.onchange = dateCallback;
    date.onblur = dateCallback;
    date.onkeyup = dateCallback;
    
    let priceCallback = function(event) {
        let error = event.target.nextElementSibling;
        error.textContent = validatePrice() ? "" : "You must enter a positive price!";
    
        addButton.disabled = !validate();
    };
    price.onchange = priceCallback;
    price.onblur = priceCallback;
    price.onkeyup = priceCallback;
    
    document.querySelector("form").onsubmit = function(event) {
        if (!validate()) {
            event.preventDefault();
        }
    }

    addButton.disabled = !validate();
}
