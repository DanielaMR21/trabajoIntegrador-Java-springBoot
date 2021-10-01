window.addEventListener("load", function(){
    const form = document.querySelector("#add_new_paciente");
        if(form){
            form.addEventListener("submit", function(e){
                e.preventDefault();

                const settingsPaciente = {
                    method : "POST",
                    headers : {
                        "content-type" : "application/json"
                    },
                    body : JSON.stringify({
                        nombre : document.querySelector("#nombre").value,
                        apellido :  document.querySelector("#apellido").value,
                        dni: document.querySelector("#dni").value,
                        fechaDeAlta:document.querySelector("#fechaAlta").value,
                        domicilio: {
                            id:document.querySelector("#id-domicilio").value
                            // calle: document.querySelector("#calle").value,
                            // numero: document.querySelector("#numero").value,
                            // localidad: document.querySelector("#localidad").value,
                            // provincia: document.querySelector("#provincia").value,
                        }
                    })
                }

                fetch("/pacientes", settingsPaciente)
                    .then(function (response) {
                        if (!response.ok) throw Error(response.status);
                        return response.json()
                    })
                    .then(function (data) {
                        console.log(data);
                         let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                                '<strong></strong> Paciente agregado </div>'
                                                document.querySelector("#response").innerHTML = successAlert;
                                                document.querySelector("#response").style.display = "block";
                                                resetForm();
                    })
                    .catch(function (error) {
                        console.log(error);
                          let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                                '<strong> Error, intente nuevamente</strong> </div>'
                                                document.querySelector("#response").innerHTML = errorAlert;
                                                document.querySelector("#response").style.display = "block";
                                                resetForm();
                    })
        })

        function resetForm(){
                document.querySelector("#nombre").value = "";
                document.querySelector("#apellido").value = "";
                document.querySelector("#dni").value = "",
                document.querySelector("#fechaAlta").value,
                document.querySelector("#id-domicilio").value = "";
                // document.querySelector("#numero").value = "";
                // document.querySelector("#localidad").value = "";
                // document.querySelector("#provincia").value = "";
            }
    }
});


