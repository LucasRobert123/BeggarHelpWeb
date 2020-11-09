<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/donor.css">
    <title>Dashboard</title>
</head>

<body>
    <div class="container-dashboard-doador">
        <header>
            <h1>Estas são as instituições que você pode ajudar</h1>
            <div class="user" onmouseover="showListOptions()">
                <p>usuario.@gmail.com</p>
                <div class="profile"></div>
                <div class="list-options" onmouseout="setDisplayNone()">
                    <div class="item">
                        <img src="./assets/power.svg" alt="power">
                        <p>Sair</p>
                    </div>
                </div>
            </div>

            <div class="group-selects">

                <select name="" id="">
                    <option value="" hidden selected>UF</option>
                    <option value="">MG</option>
                    <option value="">SP</option>
                </select>

                <select name="" id="">
                    <option value="" hidden selected>Cidade</option>
                    <option value="">Campos Gerais</option>
                    <option value="">Alfenas</option>
                </select>

                <button class="search">
                    <img src="./assets/search.svg" alt="">
                </button>
            </div>

        </header>
        <main>
            <div class="card-user">
                <header>
                    <div class="avatar">
                        <div></div>
                        <p>CAMR - Centro de Ajuda a Moradores de Rua</p>
                    </div>
                    <div class="icon-plus">
                        <img src="./assets/plus.svg" alt="plus">
                    </div>
                </header>
                <div class="content">
                    <p>
                        Nossa instituição vive de doações ,
                        com elas ajudamos milhares de moradores a rua a não passar fome nem frio
                    </p>
                </div>
                <div class="btn">
                    <button>
                        Quero doar
                    </button>
                </div>

            </div>

            <div class="card-user">
                <header>
                    <div class="avatar">
                        <div></div>
                        <p>CAMR - Centro de Ajuda a Moradores de Rua</p>
                    </div>
                    <div class="icon-plus">
                        <img src="./assets/plus.svg" alt="plus">
                    </div>
                </header>
                <div class="content">
                    <p>
                        Nossa instituição vive de doações ,
                        com elas ajudamos milhares de moradores a rua a não passar fome nem frio
                    </p>
                </div>
                <div class="btn">
                    <button>
                        Quero doar
                    </button>
                </div>

            </div>


           <div class="card-user">
                <header>
                    <div class="avatar">
                        <div></div>
                        <p>CAMR - Centro de Ajuda a Moradores de Rua</p>
                    </div>
                    <div class="icon-plus">
                        <img src="./assets/plus.svg" alt="plus">
                    </div>
                </header>
                <div class="content">
                    <p>
                        Nossa instituição vive de doações ,
                        com elas ajudamos milhares de moradores a rua a não passar fome nem frio
                    </p>
                </div>
                <div class="btn">
                    <button>
                        Quero doar
                    </button>
                </div>

            </div>

            <div class="card-user">
                <header>
                    <div class="avatar">
                        <div></div>
                        <p>CAMR - Centro de Ajuda a Moradores de Rua</p>
                    </div>
                    <div class="icon-plus">
                        <img src="./assets/plus.svg" alt="plus">
                    </div>
                </header>
                <div class="content">
                    <p>
                        Nossa instituição vive de doações ,
                        com elas ajudamos milhares de moradores a rua a não passar fome nem frio
                    </p>
                </div>
                <div class="btn">
                    <button>
                        Quero doar
                    </button>
                </div>

            </div>
        </main>
    </div>
</body>
<script>
    function showListOptions(){
        document.querySelector(".list-options").style.display = "block"
    }
    function setDisplayNone(){
        document.querySelector(".list-options").style.display = "none"
    }
</script>
</html>