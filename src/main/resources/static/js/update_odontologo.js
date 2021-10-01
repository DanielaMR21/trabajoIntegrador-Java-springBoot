function editarOdontologo(){
    document.querySelector('#btn-update-odontologo').addEventListener('click', function(e){

        const settings = {
            method : "PUT",
            headers : {
               "content-type" : "application/json",
            },
            body : JSON.stringify({
               "id" : document.querySelector("#id-odontologo").value,
               "nombre" : document.querySelector("#nombre").value,
               "apellido" :  document.querySelector("#apellido").value,
               "matricula": document.querySelector("#matricula").value,
            })
        }

       const id= document.querySelector("#id-odontologo").value;
         fetch(('/odontologos/'+id), settings)
         .then(response => {
            console.log(response.status);
            console.log(id)
            mostrarTodos();
         })
    })
}