<form name="frmForm" method="post" action="actcollection_menu.jsp?act=add&code=<%= temp %>">
  <table bgcolor="black" border="0" cellpadding="3" cellspacing="1" width="100%">

    <tr bgcolor="#ffffff" valign="top"> 
      <td width="33%"> 
        <div align="right"><font color="ff0000">*</font> Collection ID:</div>
      </td>
      <td width="67%"> 
        <input type="text" name="collection_id" maxlength="28" size="40" readonly>
        <input type="button"  value="View Collection" onclick="GoAddressCollection();">
        <input type="hidden" name="detail_id"  maxlength="28" size="28" value="<%= randomID.generate() %>">
      </td> 
    </tr>
    <tr bgcolor="#ffffff" valign="top"> 
      <td width="33%"> 
        <div align="right">Collection Name:</div>
      </td>
      <td width="67%">
        <input type="comment" name="collection_name" maxlength="128" size="40" readonly>
        </td>
      
    </tr>
    
    <tr bgcolor="#ffffff" valign="top">
    <td align="right" width="25%">&nbsp;</td>
    <td colspan="2"><font color="ff0000">*</font> required <br><div align="right">
          
          <input type="submit" value=" Add Collection " onclick="ceksubmit(); return false;"></div></td></tr>
  </table>
</form>
