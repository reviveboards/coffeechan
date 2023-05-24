$(document).ready(function(){
    $(".boardManager").hide();
    $(".userManager").hide();
    $(".banManager").hide();


    $("#bAdminListItem").click(function (){
        $(".statistics").hide();
        $(".userManager").hide();
        $(".banManager").hide();
        $(".boardManager").show(250);
        $("#adminPanelHeader").text("Manage boards");
    });

    $("#uAdminListItem").click(function (){
        $(".statistics").hide();
        $(".userManager").show(250);
        $(".banManager").hide();
        $(".boardManager").hide();
        $("#adminPanelHeader").text("Manage users");
    });

    $("#mAdminListItem").click(function (){
        $(".statistics").hide();
        $(".userManager").hide();
        $(".banManager").show(250);
        $(".boardManager").hide();
        $("#adminPanelHeader").text("Manage bans");
    });

    $("#boardMgrCreateForm").hide();
    $("#boardMgrCreateNew").click(function(){
        $("#boardMgrCreateForm").show(250);
    });
});
