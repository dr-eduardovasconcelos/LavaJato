/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.querySelector("[bodySubmiterEsteNaoExiste]").addEventListener("submit", function (event) {
    event.preventDefault()

    let mForm = event.target

    let fData = new FormData(mForm);
    
    let payload = {};
    
    for(let [name, value] of fData) {
        if(name !== "passs"){
            payload[name] = value;
        }
    }
    
    const xhr = new XMLHttpRequest()
    const url = mForm.getAttribute("action")
    xhr.open("POST", url, true)
    xhr.setRequestHeader("Content-Type", "application/json")
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            location.href = mForm.getAttribute("successRedirect")
        } else if (xhr.readyState === 4) {
            alert("Erro ao cadastrar")
        }

    }
    xhr.send(JSON.stringify(payload))

})