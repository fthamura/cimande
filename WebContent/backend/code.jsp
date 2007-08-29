<%@ include file="/include/global.inc.jsp" %>
<html>
<head>
<title>Blue Oxygen Cimande</title>
<script type="text/javascript" src="jscript/mtmcode.js"></script>
<script type="text/javascript">
// Morten's JavaScript Tree Menu
// version 2.3.0, dated 2001-04-30
// http://www.treemenu.com/

// Copyright (c) 2001, Morten Wang & contributors
// All rights reserved.

// This software is released under the BSD License which should accompany
// it in the file "COPYING".  If you do not have this file you can access
// the license through the WWW at http://www.treemenu.com/license.txt

/******************************************************************************
* User-configurable options.                                                  *
******************************************************************************/

// Menu table width, either a pixel-value (number) or a percentage value.
var MTMTableWidth = "100%";

// Name of the frame where the menu is to appear.
var MTMenuFrame = "menu";

// variable for determining whether a sub-menu always gets a plus-sign
// regardless of whether it holds another sub-menu or not
var MTMSubsGetPlus = "Always";

// variable that defines whether the menu emulates the behaviour of
// Windows Explorer
var MTMEmulateWE = true;

// Directory of menu images/icons
var MTMenuImageDirectory = "menu-images/";

// Variables for controlling colors in the menu document.
// Regular BODY atttributes as in HTML documents.
var MTMBGColor = "#D0DCE0";
var MTMBackground = "";
var MTMTextColor = "black";

// color for all menu items
var MTMLinkColor = "black";

// Hover color, when the mouse is over a menu link
var MTMAhoverColor = "red";

// Foreground color for the tracking & clicked submenu item
var MTMTrackColor ="red";
var MTMSubExpandColor = "black";
var MTMSubClosedColor = "blue";

// All options regarding the root text and it's icon
var MTMRootIcon = "menu_new_root.gif";
var MTMenuText = "<b>Site Management:</b>";
var MTMRootColor = "black";
var MTMRootFont = "Tahoma, Helvetica, sans-serif";
var MTMRootCSSize = "84%";
var MTMRootFontSize = "-1";

// Font for menu items.
var MTMenuFont = "Tahoma, Helvetica, sans-serif";
var MTMenuCSSize = "84%";
var MTMenuFontSize = "-1";

// Variables for style sheet usage
// 'true' means use a linked style sheet.
var MTMLinkedSS = true;
var MTMSSHREF = "menu.css";

// Additional style sheet properties if you're not using a linked style sheet.
// See the documentation for details on IDs, classes & elements used in the menu.
// Empty string if not used.
var MTMExtraCSS = "";

// Header & footer, these are plain HTML.
// Leave them to be "" if you're not using them

var MTMHeader = "";
var MTMFooter = "";

// Whether you want an open sub-menu to close automagically
// when another sub-menu is opened.  'true' means auto-close
var MTMSubsAutoClose = "";

// This variable controls how long it will take for the menu
// to appear if the tracking code in the content frame has
// failed to display the menu. Number if in tenths of a second
// (1/10) so 10 means "wait 1 second".
var MTMTimeOut = 1;

// Cookie usage.  First is use cookie (yes/no, true/false).
// Second is cookie name to use.
// Third is how many days we want the cookie to be stored.

var MTMUseCookies = false;
var MTMCookieName = "MTMCookie";
var MTMCookieDays = 3;

// Tool tips.  A true/false-value defining whether the support
// for tool tips should exist or not.
var MTMUseToolTips = true;
</script type="text/javascript">
<script type="text/javascript">

/******************************************************************************
* User-configurable list of icons.                                            *
******************************************************************************/

var MTMIconList = null;
MTMIconList = new IconList();
MTMIconList.addIcon(new MTMIcon("menu_link_external.gif", "http://", "pre"));
MTMIconList.addIcon(new MTMIcon("menu_link_pdf.gif", ".pdf", "post"));

/******************************************************************************
* User-configurable menu.                                                     *
******************************************************************************/

// Main menu.

<%
String sGA_USER, sGS_USER;
sGA_USER=(String)session.getAttribute("GA_USER");
sGS_USER=(String)session.getAttribute("GS_USER");

if (sGA_USER!=null && sGS_USER!=null) {
	String sRoleId=null;
	mySQL = "SELECT role_id FROM backend_user WHERE backend_user.id='"+loginBean.getMemberId()+"'";
	myResultSet=dbBean.execSQL(mySQL);
	myResultSet.next();
	sRoleId=myResultSet.getString("role_id");
	System.out.println(sGS_USER);

NavigationTree navTree ;
//navTree = new NavigationTree(sRoleId,sGS_USER);
%>
<%=navTree.getMTMScript()%>
<%

} else {
	
%>

<%
}

%>
		
</script>
</head>
<body onload="MTMStartMenu()" >

</body>
</html>
